create table IF NOT EXISTS security_db.t_subject
(
    subject_id          int UNSIGNED     NOT NULL AUTO_INCREMENT COMMENT '用户id',
    password            VARCHAR(256) COMMENT '密码',
    fingerprint         VARCHAR(256) COMMENT '指纹',
    face_identification VARCHAR(256) COMMENT '人脸识别',
    version             INT UNSIGNED     NOT NULL DEFAULT 0 COMMENT '乐观锁版本',
    status      varchar(12)             NOT NULL default 'VALID' COMMENT '状态',
    create_by           VARCHAR(64)      NOT NULL default 'SYSTEM' COMMENT '创建人',
    create_time         DATETIME         NOT NULL default now() COMMENT '创建时间',
    update_by           VARCHAR(64)      NOT NULL default 'SYSTEM' COMMENT '修改人',
    update_time         DATETIME         NOT NULL default now() COMMENT '修改时间',
    PRIMARY KEY (subject_id),
    INDEX (update_time)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '认证主体表';


DELIMITER //
CREATE TRIGGER security_db.t_subject_before_insert
    BEFORE INSERT
    ON security_db.t_subject
    FOR EACH ROW
begin
    if (new.create_time is null) then
        set new.create_time = now();
    end if;
end
//
CREATE TRIGGER security_db.t_subject_before_update
    before UPDATE
    ON security_db.t_subject
    FOR EACH ROW
begin
    set NEW.update_time = now(),NEW.version = OLD.version + 1;
end
//

DELIMITER ;