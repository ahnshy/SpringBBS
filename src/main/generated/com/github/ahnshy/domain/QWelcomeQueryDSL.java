package com.github.ahnshy.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWelcomeQueryDSL is a Querydsl query type for WelcomeQueryDSL
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWelcomeQueryDSL extends EntityPathBase<WelcomeQueryDSL> {

    private static final long serialVersionUID = 2074706528L;

    public static final QWelcomeQueryDSL welcomeQueryDSL = new QWelcomeQueryDSL("welcomeQueryDSL");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QWelcomeQueryDSL(String variable) {
        super(WelcomeQueryDSL.class, forVariable(variable));
    }

    public QWelcomeQueryDSL(Path<? extends WelcomeQueryDSL> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWelcomeQueryDSL(PathMetadata metadata) {
        super(WelcomeQueryDSL.class, metadata);
    }

}

