package kr.myproject.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;

import kr.myproject.board.entity.Board;
import kr.myproject.board.entity.QBoard;
import kr.myproject.board.entity.Search;
import kr.myproject.board.repository.BoardRepository;
import kr.myproject.board.service.BoardService;
import kr.myproject.category.QCategory;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepo;

	@Override
	public Page<Board> listBoard(Search search, Pageable pageable) {

		BooleanBuilder builder = new BooleanBuilder();
		QBoard qboard = QBoard.board;
		builder.and(qboard.category.categoryid.like("%" + search.getSearchCategory() + "%"));

		if (search.getSearchCondition().equals("TITLE")) {
			builder.and(qboard.title.like("%" + search.getSearchKeyword() + "%"));
		} else if (search.getSearchCondition().equals("CONTENT")) {
			builder.and(qboard.content.like("%" + search.getSearchKeyword() + "%"));
		}
//		pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "seq");
		return boardRepo.findAll(builder, pageable);
	}

	@Override
	public Board getBoard(Board board) {
		return boardRepo.findById(board.getSeq()).get();

	}

	@Override
	public void insertBoard(Board board) {
		boardRepo.save(board);

	}

	@Override
	public void updateBoard(Board board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get();

		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);

	}

	@Override
	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());

	}

}
