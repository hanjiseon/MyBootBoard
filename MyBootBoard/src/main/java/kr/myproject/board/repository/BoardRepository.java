package kr.myproject.board.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import kr.myproject.board.entity.Board;

public interface BoardRepository extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board> {

	@Query(" SELECT b FROM Board b")
	Page<Board> listBoard(Pageable pageable);

}
