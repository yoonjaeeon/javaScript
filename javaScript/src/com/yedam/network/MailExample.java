package com.yedam.network;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailExample {
	public static void main(String[] args) throws AddressException, MessagingException {
		String host = "smtp.gmail.com"; // Mail서버
		final String user = "gamemax125@gmail.com"; // ID
		final String passwd = "wodjs2758"; // 비밀번호

		String toUser = "gamemax125@gmail.com"; // 수신 메일주소

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 587); 
		props.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, passwd);
			}
		});
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(user));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(toUser));

		message.setSubject("네이버 메일 테스트"); // 메일 제목
		message.setText("네이버 메일 내용 부분"); // 메일 본문
		Transport.send(message); // 메일 발송
		System.out.println("메일 전송됨");
	}
}