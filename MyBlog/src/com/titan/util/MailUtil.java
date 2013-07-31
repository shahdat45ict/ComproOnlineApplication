package com.titan.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import sessioninview.User;

/**
 * added by YanlongWang
 */
public abstract class MailUtil {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setFirstName("Yanlong");
		user.setLastName("Wang");
		user.setEmail("wangyanlong0107@gmail.com");
	}

	public static void sendEmailTo(final String desAddress,final String subject,final String content) {
		new Thread(new Runnable() {
			public void run() {
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.163.com");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class",
						"javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "465");
		 
				Session session = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication("wangyanlong0107@163.com","wozhiaiziji");
						}
					});
		 
				try {
		 
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("wangyanlong0107@163.com"));
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(desAddress));
					message.setSubject(subject);
					message.setText("Dear applicant,\n\n" + content
							+ "\n\n Best wishes,\nTitan Group");
		 
					Transport.send(message);
					System.out.println("TO:" + desAddress);
					System.out.println("from:wangyanlong0107@163.com" );
					System.out.println("Done");
		 
				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}finally{
				}
			}
		}).start();
	}


}
