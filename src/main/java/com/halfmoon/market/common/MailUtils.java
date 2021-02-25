package com.halfmoon.market.common;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.halfmoon.market.model.dto.UserDTO;

public class MailUtils {
	private String userId;
	private String userPw;	
	private String host;
	private String port;
	private String fromEmail;
	
	public int sendJoinEmail(final String toEmail, final UserDTO dto) {
		String subject = "[반월마켓] 회원가입 인증 이메일 입니다.";
		// 나중에 본인이 구동하는 서버 ip로 고칠것.
		String body = String.format("<div><a href=\"http://192.168.219.105:8090/joinSucess?i_user=%d\">회원가입 인증하기</a></div>", dto.getI_user());		
		return sendMail(toEmail, subject, body);
	}
	
	public int sendFindPwEmail(final String toEmail, final String code) {
		String subject = "[반월마켓] 비밀번호 찾기 인증 이메일 입니다.";
		String body = String.format("<div>안녕하세요 코드는 %s입니다.</div>", code);		
		return sendMail(toEmail, subject, body);
	}
	
	public int sendMail(final String toEmail, final String subject, final String body) {
		try {
			Properties prop = new Properties();
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.port", port);
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.ssl.trust", host);
			
			//Session 생성 
			Session session = Session.getDefaultInstance(prop, new Authenticator() {
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() { 
					return new javax.mail.PasswordAuthentication(userId, userPw); 
				}			
			});
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject(subject);
						
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(body, "text/html; charset=UTF-8");
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			
			message.setContent(multipart);			
			Transport.send(message);			
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
}
