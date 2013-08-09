package mum.compro.mail.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import mum.compro.onlineapp.User;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * added by YanlongWang
 */
public abstract class MailUtil {



	public static void sendEmailTo(final String desAddress,final String subject,final String content) {
		new Thread(new Runnable() {
			public void run() {
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class",
						"javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "465");
		 
				Session session = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication("ComproTitan@gmail.com","compro123");
						}
					});
		 
				try {
		 
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("ComproTitan@gmail.com"));
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(desAddress));
					message.setSubject(subject);
					message.setText("Dear applicant,\n\n" + content
							+ "\n\n Best wishes,\nTitan Group");
		 
					Transport.send(message);
					System.out.println("TO:" + desAddress);
					System.out.println("from:ComproTitan@gmail.com" );
					System.out.println("Done");
		 
				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}finally{
				}
			}
		}).start();
	}


}
