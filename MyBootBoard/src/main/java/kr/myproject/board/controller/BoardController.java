package kr.myproject.board.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.myprojcet.mail.service.MailService;
import kr.myproject.board.entity.Board;
import kr.myproject.board.entity.Search;
import kr.myproject.board.excel.ExcelService;
import kr.myproject.board.service.BoardService;
import kr.myproject.mail.domain.MailDTO;
import kr.myproject.security.entity.SecurityUser;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private ExcelService excelService;

	@Autowired
	private MailService mailService;

	@RequestMapping("/board/listBoard")
	public String listBoard(Model model, Board board, Search search, @PageableDefault(size = 10) Pageable pageable) {
		
		if (search.getSearchCategory() == null)
			search.setSearchCategory("");
		
		if (search.getSearchKeyword() == null)
			search.setSearchKeyword("");
		
		if (search.getSearchCondition() == null)
			search.setSearchCondition("");
		Page<Board> boardList = boardService.listBoard(search, pageable);

		model.addAttribute("boardList", boardList);
		return "/board/listBoard";
	}

	@GetMapping("/board/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "/board/getBoard";
	}

	@GetMapping("/board/insertBoard")
	public String insertBoard() {
		return "/board/insertBoard";
	}

	@PostMapping("/board/insertBoardProc")
	public String insertBoardProc(Board board, @AuthenticationPrincipal SecurityUser principal) {

		board.setMember(principal.getMember());
		boardService.insertBoard(board);
		return "redirect:/board/listBoard";
	}

	@PostMapping("/board/updateBoardProc")
	public String updateBoardProc(Board board) {
		boardService.updateBoard(board);
		return "redirect:/board/listBoard";
	}

	@GetMapping("/board/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "redirect:/board/listBoard";
	}

	@GetMapping("/board/download")
	public void download(HttpServletResponse response) throws IOException {
		excelService.download(response);
	}

	@GetMapping("/board/mail")
	public String mail(MailDTO mailDTO) {
		mailService.sendSimpleMail(new MailDTO("han1459@cu.ac.kr", "안녕하세요", "내용"));
		return "redirect:/board/mail";
	}
}
