create table IF NOT EXISTS gateway_db.t_route
(
    id          int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    route_id    varchar(32)  NOT NULL COMMENT '路由id',
    uri         varchar(512)            NOT NULL COMMENT '路由uri',
    `order`     int UNSIGNED            NOT NULL default 2147483647 COMMENT '优先级',
    metadata    varchar(256) COMMENT '元数据',
    version     INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '乐观锁版本',
    data_status varchar(12)  NOT NULL default 'INVALID' COMMENT '数据状态',
    deleted     varchar(3)   NOT NULL default 'NO' COMMENT '是否已经删除',
    created_by   VARCHAR(64)  NOT NULL default 'SYSTEM' COMMENT '创建人',
    created_date DATETIME     NOT NULL default now() COMMENT '创建时间',
    last_modified_by   VARCHAR(64)  NOT NULL default 'SYSTEM' COMMENT '修改人',
    last_modified_date DATETIME     NOT NULL default now() COMMENT '修改时间',
    PRIMARY KEY (id),
    INDEX (last_modified_date),
    unique key(route_id),
    INDEX (uri)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


