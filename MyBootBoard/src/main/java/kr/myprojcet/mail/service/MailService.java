package kr.myprojcet.mail.service;

import kr.myproject.mail.domain.MailDTO;

public interface MailService {

	public abstract void sendSimpleMail(MailDTO mailDTO);


}