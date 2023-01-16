package kr.myproject.board.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.myproject.board.entity.Board;
import kr.myproject.board.entity.Search;

public interface BoardService {
	
	public Page<Board> listBoard(Search search, Pageable pageable);

	public void insertBoard(Board board);
	
	public void updateBoard(Board board);
	
	public void deleteBoard(Board board);

	public Board getBoard(Board board);

}
