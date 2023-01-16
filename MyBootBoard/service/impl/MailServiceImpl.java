package kr.kwangan2.springbootmailer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kwangan2.springbootmailer.component.GoogleSMTPMailSender;
import kr.kwangan2.springbootmailer.domain.MailDTO;
import kr.kwangan2.springbootmailer.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private GoogleSMTPMailSender mailSender;

	@Override
	public void sendSimpleMail(MailDTO mailDTO) {
		mailSender.sendSimpleMessage(mailDTO);
	}

	@Override
	public void sendAttachMail(MailDTO mailDTO) {
		try {
			mailSender.sendMessageWithAttachment(mailDTO);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

} // class




