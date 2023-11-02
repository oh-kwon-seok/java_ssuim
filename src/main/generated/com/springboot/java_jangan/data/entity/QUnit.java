package com.springboot.java_jangan.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUnit is a Querydsl query type for Unit
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUnit extends EntityPathBase<Unit> {

    private static final long serialVersionUID = 552203137L;

    public static final QUnit unit = new QUnit("unit");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deleted = _super.deleted;

    public final StringPath name = createString("name");

    public final NumberPath<Long> uid = createNumber("uid", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated = _super.updated;

    //inherited
    public final NumberPath<Integer> used = _super.used;

    public QUnit(String variable) {
        super(Unit.class, forVariable(variable));
    }

    public QUnit(Path<? extends Unit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUnit(PathMetadata metadata) {
        super(Unit.class, metadata);
    }

}

