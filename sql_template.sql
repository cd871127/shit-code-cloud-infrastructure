create table IF NOT EXISTS ${dn_name}_db.t_${table_name}
(
    unique_id   int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '唯一键',
    version     INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '乐观锁版本',
    status      tinyint unsigned NOT NULL default 0 COMMENT '状态0-无效 1-有效',
    create_by   VARCHAR(64)  NOT NULL default 'SYSTEM' COMMENT '创建人',
    create_time DATETIME     NOT NULL default now() COMMENT '创建时间',
    update_by   VARCHAR(64)  NOT NULL default 'SYSTEM' COMMENT '修改人',
    update_time DATETIME     NOT NULL default now() COMMENT '修改时间',
    primary key (create_time)
--     foreign key (route_id) references gateway_db.t_route (id) ON DELETE CASCADE,
--     INDEX (route_id, name),
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


DELIMITER //
CREATE TRIGGER ${dn_name}_db.t_${table_name}_before_insert
    BEFORE INSERT
    ON ${dn_name}_db.t_${table_name}
    FOR EACH ROW
begin
    if (new.create_time is null) then
        set new.create_time = now();
    end if;
end
//
CREATE TRIGGER ${dn_name}_db.t_${table_name}_before_update
    before UPDATE
    ON ${dn_name}_db.t_${table_name}
    FOR EACH ROW
begin
    set NEW.update_time = now(),NEW.version = OLD.version + 1;
end
//

DELIMITER ;