create table IF NOT EXISTS gateway_db.t_route_accessory
(
    name        VARCHAR(128) NOT NULL,
    args        VARCHAR(256),
    type        VARCHAR(10)  NOT NULL,
    route_id    varchar(32)  NOT NULL COMMENT '路由id',
    version     INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '乐观锁版本',
    status      varchar(12)  NOT NULL default 'INVALID' COMMENT '状态',
    create_by   VARCHAR(64)             NOT NULL default 'SYSTEM' COMMENT '创建人',
    create_time DATETIME                NOT NULL default now() COMMENT '创建时间',
    update_by   VARCHAR(64)             NOT NULL default 'SYSTEM' COMMENT '修改人',
    update_time DATETIME                NOT NULL default now() COMMENT '修改时间',
    foreign key (route_id) references gateway_db.t_route (id) ON DELETE CASCADE,
    INDEX (route_id,name)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


DELIMITER //
CREATE TRIGGER gateway_db.t_route_accessory_before_insert
    BEFORE INSERT
    ON gateway_db.t_route_accessory
    FOR EACH ROW
begin
    if (new.create_time is null) then
        set new.create_time = now();
    end if;
end
//
CREATE TRIGGER gateway_db.t_route_accessory_before_update
    before UPDATE
    ON gateway_db.t_route_accessory
    FOR EACH ROW
begin
    set NEW.update_time = now(),NEW.version = OLD.version + 1;
end
//

DELIMITER ;