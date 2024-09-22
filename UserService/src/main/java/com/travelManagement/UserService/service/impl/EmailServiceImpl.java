package com.travelManagement.UserService.service.impl;

import java.util.concurrent.CompletableFuture;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.travelManagement.UserService.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	private JavaMailSender mailSender;

	@Override
	public CompletableFuture<Void> sendEmail(String to, String subject, String text) {
		// TODO Auto-generated method stub

		CompletableFuture<Void> future = new CompletableFuture<>();

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
			messageHelper.setTo(to);
			messageHelper.setSubject(subject);
			messageHelper.setText(text, true);
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return future;

	}

	@Override
	public String getOtpEmailTemplate(String name, String phoneNumber, String otp) {
		// TODO Auto-generated method stub

		String emailTemplate = "<div style=\"font-family: Helvetica,Arial,sans-serif;min-width:1000px;overflow:auto;line-height:2\">"
				+ "<div style=\"margin:50px auto;width:70%;padding:20px 0\">"
				+ "<div style=\"border-bottom:1px solid #eee\">"
				+ "<a href=\"https://piggybank.netlify.app/\" style=\"font-size:1.4em;color: #00466a;text-decoration:none;font-weight:600\">piggybank</a>"
				+ "</div>" + "<p style=\"font-size:1.1em\">Hi, " + name + "</p>"
				+ "<p style=\"font-size:0.9em;\">Phone Number: " + phoneNumber + "</p>"
				+ "<p>Thank you for choosing TravelManagement. Use the following OTP to complete your Log In procedures. OTP is valid for 5 minutes</p>"
				+ "<h2 style=\"background: #00466a;margin: 0 auto;width: max-content;padding: 0 10px;color: #fff;border-radius: 4px;\">"
				+ otp + "</h2>" + "<p style=\"font-size:0.9em;\">Regards,<br />TravelManagement</p>"
				+ "<hr style=\"border:none;border-top:1px solid #eee\" />" + "<p>piggybank Inc</p>"
				+ "<p>1600 Amphitheatre Parkway</p>" + "<p>California</p>" + "</div>" + "</div>";
		return emailTemplate;
	}

}
