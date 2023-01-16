package kr.myproject.member.repository;

import org.springframework.data.repository.CrudRepository;

import kr.myproject.member.entity.Member;

public interface MemberRepository extends CrudRepository<Member, String> {
	
	

}
