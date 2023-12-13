/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


/**
 *
 * @author Admin
 */

public class SendMailJavaClass {
        public static void sendMail(String recieverMail) {
        // Recipient's email ID needs to be mentioned.
        String to = recieverMail;

        // Sender's email ID needs to be mentioned
        final String from = "sondanh2911@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";


        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        System.getenv("EMAIL");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                 //setup app password reference https://support.google.com/accounts/answer/185833?hl=en
                return new PasswordAuthentication(from, "uroayolsyvidsaaj");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Your order has been processing.");

            // Now set the actual message
            String textformail ="Thank For Your Order"
                    + "\n"
                    + "Your order have been processing"
                    + "\n"
                    + "Please wait a few days and your order will arrive :3";
            message.setText(textformail);
                
                
            //message.setText("Vietnam opening!");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
    public static void main(String [] args){
        sendMail("sonembd@gmail.com");       
    }
}