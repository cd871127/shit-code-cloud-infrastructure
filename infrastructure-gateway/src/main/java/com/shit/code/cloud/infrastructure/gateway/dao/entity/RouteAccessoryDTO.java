package com.shit.code.cloud.infrastructure.gateway.dao.entity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.shit.code.cloud.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;

import java.util.HashMap;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@NoArgsConstructor
public class RouteAccessoryDTO extends BaseEntity {
    public RouteAccessoryDTO(String routeId, AccessoryType accessoryType) {
        this.routeId = routeId;
        this.type = accessoryType;
    }

    /**
     * 名字
     */
    private String name;
    /**
     * 参数
     */
    private String args;
    /**
     * 附件类型
     */
    private AccessoryType type;
    /**
     * 路由ID
     */
    private String routeId;

    public static RouteAccessoryDTO fromDefinition(String routeId, FilterDefinition filterDefinition) {
        RouteAccessoryDTO routeAccessoryDTO = new RouteAccessoryDTO(routeId, AccessoryType.FILTER);
        routeAccessoryDTO.setName(filterDefinition.getName());
        routeAccessoryDTO.setArgs(JSONObject.toJSONString(filterDefinition.getArgs()));
        return routeAccessoryDTO;
    }

    public static RouteAccessoryDTO fromDefinition(String routeId, PredicateDefinition predicateDefinition) {
        RouteAccessoryDTO routeAccessoryDTO = new RouteAccessoryDTO(routeId, AccessoryType.PREDICATE);
        routeAccessoryDTO.setName(predicateDefinition.getName());
        routeAccessoryDTO.setArgs(JSONObject.toJSONString(predicateDefinition.getArgs()));
        return routeAccessoryDTO;
    }


    public FilterDefinition toFilterDefinition() {
        FilterDefinition filterDefinition = new FilterDefinition();
        filterDefinition.setName(name);
        filterDefinition.setArgs(JSONObject
                .parseObject(args, new TypeReference<HashMap<String, String>>() {
                }));
        return filterDefinition;
    }

    public PredicateDefinition toPredicateDefinition() {
        PredicateDefinition predicateDefinition = new PredicateDefinition();
        predicateDefinition.setName(name);
        predicateDefinition.setArgs(JSONObject
                .parseObject(args, new TypeReference<HashMap<String, String>>() {
                }));
        return predicateDefinition;
    }

    public enum AccessoryType {
        /**
         * 断言和过滤器
         */
        PREDICATE, FILTER;
    }

}
