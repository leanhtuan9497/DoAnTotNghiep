package com.leanhtuan.tools;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public boolean sendMail(String to, String subject, String text) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("leanhtuan9497.work@gmail.com", "xbmkagccbqfjmwus");
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.addHeader("Content-Type", "text/plain; charset=UTF-8");
			message.addHeader("format", "flowed");
			message.addHeader("Content-Transfer-Encoding", "8bit");
			message.setFrom(new InternetAddress("UNIFY"));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(text);
			System.out.println("Msg ready");
			Transport.send(message);
			System.out.println("Sent");
		} catch (MessagingException e) {
			return false;
		}
		return true;
	}
}
