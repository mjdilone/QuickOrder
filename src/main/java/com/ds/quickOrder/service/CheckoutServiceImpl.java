package com.ds.quickOrder.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.quickOrder.controller.CartController;
import com.ds.quickOrder.dao.CheckoutDaoImpl;

@Service
public class CheckoutServiceImpl implements CheckoutService {
	private static Logger log = LoggerFactory.getLogger(CartController.class);

	@Autowired
	CheckoutDaoImpl checkoutDao;
	
	@Override
	public void sendCheckoutEmail(int id) {
		
		try {
			StringBuilder emailDraft = new StringBuilder(checkoutDao.prepareCheckoutEmail(id));
			
			//send an email
			//username and password for sending the email
			 final String username = Constants.EMAIL_USERNAME_FROM;
		     final String password = Constants.EMAIL_PASSWORD;

		     	Properties prop = new Properties();
				prop.put("mail.smtp.host", "smtp.gmail.com");
		        prop.put("mail.smtp.port", "587");
		        prop.put("mail.smtp.auth", "true");
		        prop.put("mail.smtp.starttls.enable", "true"); //TLS
		        
		        Session session = Session.getInstance(prop,
		                new javax.mail.Authenticator() {
		                    protected PasswordAuthentication getPasswordAuthentication() {
		                        return new PasswordAuthentication(username, password);
		                    }
		                });
		        try {

		            Message message = new MimeMessage(session);
		            message.setFrom(new InternetAddress(Constants.EMAIL_USERNAME_FROM));
		            message.setRecipients(
		                    Message.RecipientType.TO,
		                    InternetAddress.parse(Constants.EMAIL_USERNAME_TO)
		            );
		            message.setSubject(Constants.EMAIL_SUBJECT);
		            
		            System.out.println("Email Draft:");
		            System.out.println(emailDraft);
		            message.setText(emailDraft.toString());
		            Transport.send(message);
		            System.out.println("The email has to been sent");
		        } catch (MessagingException e) {
		            e.printStackTrace();
		            System.out.println("Less Secured Apps have not been allowed, allow them at https://myaccount.google.com/lesssecureapps ");
		        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	class Constants {
		public static final String EMAIL_USERNAME_FROM = "mjdilone7794@gmail.com";
		public static final String EMAIL_PASSWORD = "carbuncle7794";
		public static final String EMAIL_USERNAME_TO = "mjdilone7794two@gmail.com";
		public static final String EMAIL_SUBJECT = "Planner Update";
	}

	public void checkout(int id) {
		log.info("Method Entry " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		try {
			checkoutDao.checkout(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
