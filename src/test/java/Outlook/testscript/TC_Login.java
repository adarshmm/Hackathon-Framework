package Outlook.testscript;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Outlook.pages.LoginPage;
public class TC_Login extends TC_Homepage {
	
	@Test
	public static void tsalesforcesilogin() throws InterruptedException, IOException {
		
		for (int i = 1; i <= 10; i++) {
            sendEmail("adarshmm55" + "@gmail.com", "Subject", "Body of the email");
        }
		
		
	}
	
	
	private static void sendEmail(String to, String subject, String body) {
        // Replace 'your_email@example.com' and 'your_password' with your Outlook email and password
        final String username = prop.getProperty("Username");
        final String password = prop.getProperty("Password");

        // Set up JavaMail properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", "587");

        // Get the default Session object
       
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set From: header field of the header
            message.setFrom(new InternetAddress(username));

            // Set To: header field of the header
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(body);

            // Send the message
            Transport.send(message);

            System.out.println("Sent email to: " + to);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
