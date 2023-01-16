package kr.myproject.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import kr.myproject.board.domain.Role;
import kr.myproject.board.entity.Board;
import kr.myproject.board.repository.BoardRepository;
import kr.myproject.category.Category;
import kr.myproject.category.repository.CategoryRepository;
import kr.myproject.member.entity.Member;
import kr.myproject.member.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRositoryTest {

	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private CategoryRepository categoryRepo;

	@Test
	public void testInsert() {
		Member member1 = new Member();
		member1.setId("member");
		member1.setPassword(encoder.encode("member123"));
		member1.setName("둘리");
		member1.setRole(Role.ROLE_MEMBER);
		member1.setEnabled("y");
		memberRepo.save(member1);
		
		Member member2 = new Member();
		member2.setId("admin");
		member2.setPassword(encoder.encode("admin123"));
		member2.setName("도우너");
		member2.setRole(Role.ROLE_ADMIN);
		member2.setEnabled("y");
		memberRepo.save(member2);
		
		Category category1 = new Category("공지");
		categoryRepo.save(category1);
		
		Category category2 = new Category("자유");
		categoryRepo.save(category2);
		
		Category category3 = new Category("기타");
		categoryRepo.save(category3);

		for (int i = 1; i <=10 ; i++) {
			Board board = new Board(member1, member1.getName() + "게시글 제목", member1.getName() + "게시글 내용", category1);
			boardRepo.save(board);
		}

		for (int i = 1; i <= 10; i++) {
			Board board = new Board(member2, member2.getName() + "게시글 제목", member2.getName() + "게시글 내용",category2);
			boardRepo.save(board);
		}
		
		for (int i = 1; i <= 10; i++) {
			Board board = new Board(member2, member2.getName() + "게시글 제목", member2.getName() + "게시글 내용",category3);
			boardRepo.save(board);
		}


	}

}
