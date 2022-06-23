package com.sqisoft.mgapi.datasource.iqsbz3.vo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMenuVO is a Querydsl query type for MenuVO
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMenuVO extends EntityPathBase<MenuVO> {

    private static final long serialVersionUID = 2145887236L;

    public static final QMenuVO menuVO = new QMenuVO("menuVO");

    public final StringPath menuCatName = createString("menuCatName");

    public final NumberPath<Integer> menuIndex = createNumber("menuIndex", Integer.class);

    public final StringPath menuName = createString("menuName");

    public final NumberPath<Integer> menuSeq = createNumber("menuSeq", Integer.class);

    public final StringPath menuUrl = createString("menuUrl");

    public QMenuVO(String variable) {
        super(MenuVO.class, forVariable(variable));
    }

    public QMenuVO(Path<? extends MenuVO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMenuVO(PathMetadata metadata) {
        super(MenuVO.class, metadata);
    }

}

