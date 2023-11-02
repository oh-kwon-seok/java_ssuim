package com.springboot.java_jangan.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrigin is a Querydsl query type for Origin
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrigin extends EntityPathBase<Origin> {

    private static final long serialVersionUID = -2076819997L;

    public static final QOrigin origin = new QOrigin("origin");

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

    public QOrigin(String variable) {
        super(Origin.class, forVariable(variable));
    }

    public QOrigin(Path<? extends Origin> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrigin(PathMetadata metadata) {
        super(Origin.class, metadata);
    }

}

