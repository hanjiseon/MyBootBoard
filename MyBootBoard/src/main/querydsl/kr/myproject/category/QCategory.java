package kr.myproject.category;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategory is a Querydsl query type for Category
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCategory extends EntityPathBase<Category> {

    private static final long serialVersionUID = 1894844486L;

    public static final QCategory category = new QCategory("category");

    public final ListPath<kr.myproject.board.entity.Board, kr.myproject.board.entity.QBoard> boardList = this.<kr.myproject.board.entity.Board, kr.myproject.board.entity.QBoard>createList("boardList", kr.myproject.board.entity.Board.class, kr.myproject.board.entity.QBoard.class, PathInits.DIRECT2);

    public final StringPath categoryid = createString("categoryid");

    public QCategory(String variable) {
        super(Category.class, forVariable(variable));
    }

    public QCategory(Path<? extends Category> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategory(PathMetadata metadata) {
        super(Category.class, metadata);
    }

}

