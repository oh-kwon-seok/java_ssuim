package com.springboot.java_ssuim.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QShip is a Querydsl query type for Ship
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShip extends EntityPathBase<Ship> {

    private static final long serialVersionUID = 534226291L;

    public static final QShip ship = new QShip("ship");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath address = createString("address");

    public final StringPath area = createString("area");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deleted = _super.deleted;

    public final StringPath phone1 = createString("phone1");

    public final StringPath phone2 = createString("phone2");

    public final StringPath receive_user = createString("receive_user");

    public final NumberPath<Long> uid = createNumber("uid", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated = _super.updated;

    public final NumberPath<Integer> used = createNumber("used", Integer.class);

    public QShip(String variable) {
        super(Ship.class, forVariable(variable));
    }

    public QShip(Path<? extends Ship> path) {
        super(path.getType(), path.getMetadata());
    }

    public QShip(PathMetadata metadata) {
        super(Ship.class, metadata);
    }

}

