package kr.myproject.board.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import kr.myproject.category.Category;
import kr.myproject.member.entity.Member;
import lombok.Data;
import lombok.ToString;

@Entity
@ToString(exclude = "member")
@Data
public class Board {

	public Board() {

	}

	public Board(Member member,String title, String content, Category category) {
		this.member= member;
		this.title = title;
		this.content = content;
		this.category = category;
	}

	@Id
	@GeneratedValue
	private Long seq;

	private String title;

	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date createDate = new Date();

	@Column(updatable = false)
	private Long cnt = 0L;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID", nullable = false, updatable = false)
	private Member member;

	public void setMember(Member member) {
		this.member = member;
		member.getBoardList().add(this);
	}
	
	@ManyToOne
	@JoinColumn(name = "CATEGORY_id", nullable = false, updatable = false)
	private Category category;
	
	public void setCategory(Category category) {
		this.category=category;
		category.getBoardList().add(this);
	}
	
	
	
	

} // class
