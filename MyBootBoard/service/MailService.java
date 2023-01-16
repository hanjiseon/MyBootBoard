package kr.kwangan2.springbootmailer.service;

import kr.kwangan2.springbootmailer.domain.MailDTO;

public interface MailService {

	public abstract void sendSimpleMail(MailDTO mailDTO);

	public abstract void sendAttachMail(MailDTO mailDTO);

}