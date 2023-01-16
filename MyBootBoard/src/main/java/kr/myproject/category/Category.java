package kr.myproject.category;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import kr.myproject.board.entity.Board;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude = "boardList")
public class Category {

	public Category() {

	}

	public Category(String categoryid) {
		this.categoryid = categoryid;
	}

	@Column(name = "CATEGORY_id")
	@Id
	private String categoryid;

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private List<Board> boardList = new ArrayList<Board>();

}
