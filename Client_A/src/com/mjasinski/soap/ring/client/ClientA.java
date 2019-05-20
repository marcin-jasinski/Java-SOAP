package com.mjasinski.soap.ring.client;

import com.mjasinski.soap.ring.Message;
import com.mjasinski.soap.ring.RingService;
import com.mjasinski.soap.ring.RingServiceService;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Marcin on 17.05.2019
 */
public class ClientA {

    private static String internalServicePort;
    private static RingService internalService;

    private static String nextInChainPort;
    private static RingService nextInChain;

    public static void main(String[] args) {

        internalServicePort = args[0];
        nextInChainPort = args[1];

        internalService = configureServiceWithPort(internalServicePort);
        nextInChain = configureServiceWithPort(nextInChainPort);

        Scanner scanner = new Scanner(System.in);
        String operation = "";

        while(true){
            printMenu();
            operation = scanner.nextLine();

            switch (operation){
                case "1":
                    checkForNewMessages(internalServicePort, nextInChainPort);
                    break;
                case "2":
                    sendNewMessage(nextInChainPort);
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Invalid operation");
                    break;
            }
        }
    }

    private static RingService configureServiceWithPort(String port){

        RingServiceService service = null;

        String URL = "http://localhost:" + port + "/RingSOAP/services/RingService?wsdl";

        System.out.println("Receiving service definition from " + URL);
        try{
            service = new RingServiceService(new URL(URL));
            System.out.println("Service configuration received.");
        } catch (MalformedURLException e){
            e.printStackTrace();
        }

        return service.getRingService();
    }

    private static void printMenu(){
        System.out.print("Choose action: " + "\n1 - check inbox" + "\n2 - send new message" + "\n3 - EXIT" + "\n> ");
    }

    private static void checkForNewMessages(String internalServicePort, String nextInChainPort){

        if(internalService.hasPendingMessages()){

            Message receivedMessage = internalService.getSoapMessage();

            try {

                InputStream is = new ByteArrayInputStream(receivedMessage.getSoapMessage());
                SOAPMessage response = MessageFactory.newInstance().createMessage(null, is);
                is.close();

                SOAPHeader soapHeader = response.getSOAPHeader();
                java.util.Iterator headerIterator = soapHeader.getChildElements();
                SOAPHeaderElement headerElement = (SOAPHeaderElement)headerIterator.next();
                NodeList nodeList = headerElement.getChildNodes();
                String targetFromHeader = nodeList.item(0).getTextContent();
                String senderFromHeader = nodeList.item(1).getTextContent();

                SOAPBody soapBody = response.getSOAPBody();
                java.util.Iterator iterator = soapBody.getChildElements();
                SOAPBodyElement bodyElement = (SOAPBodyElement)iterator.next();
                String messageText = bodyElement.getFirstChild().getTextContent();

                System.out.println("New message received: " + messageText);

                if(senderFromHeader.equals(internalServicePort)){
                    System.out.println("Message returned to sender: " + messageText);
                } else if (!targetFromHeader.equals(internalServicePort)){
                    System.out.println("But we're not the target! Forwarding message to :" + nextInChainPort);
                    nextInChain.forwardMessage(receivedMessage);
                }
            } catch (SOAPException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No new messages...");
        }
    }

    private static void sendNewMessage(String internalServicePort){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Type message to be sent: ");
        String newMessageText = scanner.nextLine();
        System.out.print("Specify receiver port (type \"*\" for broadcast mode): ");
        String receiverPort = scanner.nextLine();

        if(!receiverPort.equals("*")){

            Message messageToSend = prepareMessage(newMessageText, receiverPort);
            nextInChain.forwardMessage(messageToSend);
            System.out.println("Message sent to receiver on " + receiverPort);
        } else {

            RingService previousInChain = configureServiceWithPort("8082");
            Message messageToSendPrevious = prepareMessage(newMessageText, "8082");
            previousInChain.forwardMessage(messageToSendPrevious);
            System.out.println("Message broadcast to receiver on " + receiverPort);

            Message messageToSend = prepareMessage(newMessageText, nextInChainPort);
            nextInChain.forwardMessage(messageToSend);
            System.out.println("Message broadcast to receiver on " + receiverPort);
        }
    }

    private static Message prepareMessage(String newMessageText, String receiverPort){

        Message messageToSend = null;

        try {
            MessageFactory factory = MessageFactory.newInstance();
            SOAPMessage message = factory.createMessage();

            SOAPHeader header = message.getSOAPHeader();

            QName headerPorts = new QName("http://soap.lab.header.pl/", "Ports", "RCS");
            SOAPHeaderElement headerElement = header.addHeaderElement(headerPorts);

            QName receiverPortName = new QName("receiverPort");
            SOAPElement headerReceiverContent = headerElement.addChildElement(receiverPortName);
            headerReceiverContent.addTextNode(receiverPort);

            QName senderPortName = new QName("senderPort");
            SOAPElement headerSenderContent = headerElement.addChildElement(senderPortName);
            headerSenderContent.addTextNode(internalServicePort);

            SOAPBody body = message.getSOAPBody();
            QName bodyName = new QName("http://soap.lab.body.message.pl/", "MessageContent", "MSG");
            SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
            QName name = new QName("message");
            SOAPElement symbol = bodyElement.addChildElement(name);
            symbol.addTextNode(newMessageText);

            message.saveChanges();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            message.writeTo(out);

            messageToSend = new Message();
            messageToSend.setSoapMessage(out.toByteArray());
            out.close();

        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return messageToSend;
    }
}
