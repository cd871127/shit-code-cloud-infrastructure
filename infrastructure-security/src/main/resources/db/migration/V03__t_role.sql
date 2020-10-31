create table IF NOT EXISTS security_db.t_role
(
    role_id     int UNSIGNED     NOT NULL AUTO_INCREMENT COMMENT '用户id',
    role_name   VARCHAR(256) COMMENT '角色名称',
    role_desc   VARCHAR(256) COMMENT '角色描述',
    version     INT UNSIGNED     NOT NULL DEFAULT 0 COMMENT '乐观锁版本',
    status      varchar(12)             NOT NULL default 'INVALID' COMMENT '状态',
    create_by   VARCHAR(64)      NOT NULL default 'SYSTEM' COMMENT '创建人',
    create_time DATETIME         NOT NULL default now() COMMENT '创建时间',
    update_by   VARCHAR(64)      NOT NULL default 'SYSTEM' COMMENT '修改人',
    update_time DATETIME         NOT NULL default now() COMMENT '修改时间',
    PRIMARY KEY (role_id),
    INDEX (update_time)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '角色表';


DELIMITER //
CREATE TRIGGER security_db.t_role_before_insert
    BEFORE INSERT
    ON security_db.t_role
    FOR EACH ROW
begin
    if (new.create_time is null) then
        set new.create_time = now();
    end if;
end
//
CREATE TRIGGER security_db.t_role_before_update
    before UPDATE
    ON security_db.t_role
    FOR EACH ROW
begin
    set NEW.update_time = now(),NEW.version = OLD.version + 1;
end
//

DELIMITER ;