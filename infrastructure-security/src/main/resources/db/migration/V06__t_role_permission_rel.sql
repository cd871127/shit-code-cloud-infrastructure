create table IF NOT EXISTS security_db.t_role_permission_rel
(
    id            int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
    role_id       int UNSIGNED NOT NULL COMMENT '角色id',
    permission_id int UNSIGNED NOT NULL COMMENT '权限id',
    version       INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '乐观锁版本',
    data_status   varchar(12)  NOT NULL default 'INVALID' COMMENT '数据状态',
    deleted       varchar(3)   NOT NULL default 'NO' COMMENT '是否已经删除',
    create_by     VARCHAR(64)  NOT NULL default 'SYSTEM' COMMENT '创建人',
    create_time   DATETIME     NOT NULL default now() COMMENT '创建时间',
    update_by     VARCHAR(64)  NOT NULL default 'SYSTEM' COMMENT '修改人',
    update_time   DATETIME     NOT NULL default now() COMMENT '修改时间',
    PRIMARY KEY (id),
    UNIQUE KEY (role_id, permission_id),
    INDEX (update_time)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '角色权限关联表';

