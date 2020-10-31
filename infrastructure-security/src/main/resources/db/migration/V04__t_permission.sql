create table IF NOT EXISTS security_db.t_permission
(
    id              int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '权限id',
    permission_name VARCHAR(256) COMMENT '权限名称',
    permission_desc VARCHAR(256) COMMENT '权限描述',
    version         INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '乐观锁版本',
    data_status     varchar(12)  NOT NULL default 'INVALID' COMMENT '数据状态',
    deleted         varchar(3)   NOT NULL default 'NO' COMMENT '是否已经删除',
    create_by       VARCHAR(64)  NOT NULL default 'SYSTEM' COMMENT '创建人',
    create_time     DATETIME     NOT NULL default now() COMMENT '创建时间',
    update_by       VARCHAR(64)  NOT NULL default 'SYSTEM' COMMENT '修改人',
    update_time     DATETIME     NOT NULL default now() COMMENT '修改时间',
    PRIMARY KEY (id),
    UNIQUE INDEX (permission_name),
    INDEX (update_time)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '权限表';


DELIMITER //
CREATE TRIGGER security_db.t_permission_before_insert
    BEFORE INSERT
    ON security_db.t_permission
    FOR EACH ROW
begin
    if (new.create_time is null) then
        set new.create_time = now();
    end if;
end
//
CREATE TRIGGER security_db.t_permission_before_update
    before UPDATE
    ON security_db.t_permission
    FOR EACH ROW
begin
    set NEW.update_time = now(),NEW.version = OLD.version + 1;
end
//

DELIMITER ;