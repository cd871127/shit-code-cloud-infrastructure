create table IF NOT EXISTS security_db.t_subject_role_rel
(
    id                 int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
    subject_id         int UNSIGNED NOT NULL COMMENT '用户id',
    role_id            int UNSIGNED NOT NULL COMMENT '角色id',
    version            INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '乐观锁版本',
    data_status        varchar(12)  NOT NULL default 'INVALID' COMMENT '数据状态',
    deleted            varchar(3)   NOT NULL default 'NO' COMMENT '是否已经删除',
    created_by         VARCHAR(64)  NOT NULL default 'SYSTEM' COMMENT '创建人',
    created_date       DATETIME     NOT NULL default now() COMMENT '创建时间',
    last_modified_by   VARCHAR(64)  NOT NULL default 'SYSTEM' COMMENT '修改人',
    last_modified_date DATETIME     NOT NULL default now() COMMENT '修改时间',
    PRIMARY KEY (id),
    INDEX (last_modified_date),
    UNIQUE KEY (subject_id, role_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '用户角色关联表';

