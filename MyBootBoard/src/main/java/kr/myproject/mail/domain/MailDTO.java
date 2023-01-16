package kr.myproject.mail.domain;

import java.io.Serializable;
import java.util.Optional;

import lombok.Data;

@Data
public class MailDTO implements Serializable {
	
	public static final long serialVersionUID = 9823477983284L;
	
	public MailDTO() {
	}
	
	public MailDTO(String to, String subject
			, String content) {
		this.to = (to==null) ? "noreceiver@noreceiver.com" : to;
		this.subject = (subject==null) ? "제목 없음" : subject;
		this.content = (content==null) ? "내용 없음" : content;
	}
	
	private String to;			// 수신자 이메일
	private String subject;		// 메일 제목
	private String content;		// 메일 내용

} // class





