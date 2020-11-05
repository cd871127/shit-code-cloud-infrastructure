package com.shit.code.cloud.infrastructure.gateway.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shit.code.cloud.infrastructure.gateway.dao.entity.RouteDTO;
import com.shit.code.cloud.infrastructure.gateway.dao.mapper.RouteMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author anthonychen
 * @date 2020/11/5
 */
@Slf4j
@Component
public class RouteDAO extends ServiceImpl<RouteMapper, RouteDTO> {
}
