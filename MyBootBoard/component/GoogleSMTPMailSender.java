package kr.kwangan2.springbootmailer.component;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import kr.kwangan2.springbootmailer.domain.MailDTO;

@Component
public class GoogleSMTPMailSender {
	
	@Autowired
	private JavaMailSender javaEmailSender;

	@Value("${google.mail.sender.email}")
	private String sender;	// 발신자 메일주소

	// 첨부파일이 없는 메일 발송
	public void sendSimpleMessage(MailDTO mailDTO) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(sender);
		message.setTo(mailDTO.getTo());
		message.setSubject(mailDTO.getSubject());
		message.setText(mailDTO.getContent());

		javaEmailSender.send(message);
	}
	
	// 첨부파일이 있는 메일 발송
	public void sendMessageWithAttachment(MailDTO mailDTO) throws Exception {

		MimeMessage message = javaEmailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setFrom(sender);
		helper.setTo(mailDTO.getTo());
		helper.setSubject(mailDTO.getSubject());
		helper.setText(mailDTO.getContent());

		File file = new File(mailDTO.getFilePath());
		FileSystemResource fileSystemResource 
			= new FileSystemResource(file);
		helper.addAttachment(file.getName(), fileSystemResource);

		javaEmailSender.send(message);
	}
	
} // class
