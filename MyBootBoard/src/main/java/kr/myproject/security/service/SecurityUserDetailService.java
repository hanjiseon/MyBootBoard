package kr.myproject.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.myproject.member.entity.Member;
import kr.myproject.member.repository.MemberRepository;
import kr.myproject.security.entity.SecurityUser;



@Service
public class SecurityUserDetailService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Member> optional = memberRepo.findById(username);
		if (!optional.isPresent()) {
			throw new UsernameNotFoundException(username + "사용자 없음");
		} else {
			Member member = optional.get();
			return new SecurityUser(member);
		}
	}
}
