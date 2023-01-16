package kr.myproject.member.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import kr.myproject.board.domain.Role;
import kr.myproject.board.entity.Board;
import lombok.Data;
import lombok.ToString;
@Entity
@Data
@ToString(exclude = "boardList")
public class Member {
	
	public Member() {
		
	}
	
	public Member(String id, String password, String name, Role role, String enabled) {
		this.id = id;
		this.password= password;
		this.name = name;
		this.role = role;
		this.enabled = enabled;
		
	}


	@Id
	@Column(name="MEMBER_ID")
	private String id;
	private String password;
	private String name;

	@Enumerated(EnumType.STRING)
	private Role role;
	
	private String enabled;
	
	
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
	private List<Board> boardList = new ArrayList<Board>();
	
	
} // class
