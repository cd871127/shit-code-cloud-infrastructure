create table IF NOT EXISTS gateway_db.t_route_accessory
(
    id          int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    name        VARCHAR(128) NOT NULL,
    args        VARCHAR(256),
    type        VARCHAR(10)  NOT NULL,
    route_id    varchar(32)  NOT NULL COMMENT '路由id',
    version     INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '乐观锁版本',
    data_status varchar(12)  NOT NULL default 'INVALID' COMMENT '数据状态',
    deleted     varchar(3)   NOT NULL default 'NO' COMMENT '是否已经删除',
    created_by   VARCHAR(64)  NOT NULL default 'SYSTEM' COMMENT '创建人',
    created_date DATETIME     NOT NULL default now() COMMENT '创建时间',
    last_modified_by   VARCHAR(64)  NOT NULL default 'SYSTEM' COMMENT '修改人',
    last_modified_date DATETIME     NOT NULL default now() COMMENT '修改时间',
    PRIMARY KEY (id),
    INDEX (last_modified_date),
    foreign key (route_id) references gateway_db.t_route (route_id) ON DELETE CASCADE,
    INDEX (route_id,name)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


