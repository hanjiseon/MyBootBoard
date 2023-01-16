package kr.myproject.mail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.myprojcet.mail.service.MailService;
import kr.myproject.mail.component.GoogleSMTPMailSender;
import kr.myproject.mail.domain.MailDTO;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private GoogleSMTPMailSender mailSender;

	@Override
	public void sendSimpleMail(MailDTO mailDTO) {
		mailSender.sendSimpleMessage(mailDTO);
	}


} // class




