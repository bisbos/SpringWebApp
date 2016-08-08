package com.quicken.entities;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QURLInfo is a Querydsl query type for URLInfo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QURLInfo extends EntityPathBase<URLInfo> {

    private static final long serialVersionUID = -1126428459L;

    public static final QURLInfo uRLInfo = new QURLInfo("uRLInfo");

    public final com.quicken.common.core.entities.QBaseEntity _super = new com.quicken.common.core.entities.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.time.ZonedDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final NumberPath<Integer> optLock = _super.optLock;

    public final StringPath platform = createString("platform");

    public final StringPath urllink = createString("urllink");

    public final StringPath urlname = createString("urlname");

    public QURLInfo(String variable) {
        super(URLInfo.class, forVariable(variable));
    }

    public QURLInfo(Path<? extends URLInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QURLInfo(PathMetadata<?> metadata) {
        super(URLInfo.class, metadata);
    }

}

