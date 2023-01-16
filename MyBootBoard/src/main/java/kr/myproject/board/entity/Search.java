package kr.myproject.board.entity;

import lombok.Data;

@Data
public class Search {
	
	private String searchCondition;
	private String searchKeyword;
	private String searchCategory;

}
