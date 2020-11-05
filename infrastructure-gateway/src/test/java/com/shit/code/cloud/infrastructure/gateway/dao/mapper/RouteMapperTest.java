package com.shit.code.cloud.infrastructure.gateway.dao.mapper;

import com.shit.code.cloud.infrastructure.gateway.BaseTest;
import com.shit.code.cloud.infrastructure.gateway.dao.entity.RouteAccessoryDTO;
import com.shit.code.cloud.infrastructure.gateway.dao.entity.RouteDTO;
import org.junit.Test;

import javax.annotation.Resource;

public class RouteMapperTest extends BaseTest {
    @Resource
    private RouteMapper routeMapper;

    @Resource
    private RouteAccessoryMapper accessoryMapper;

    @Test
    public void test() {
        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setRouteId("test");
        RouteAccessoryDTO routeAccessoryDTO = new RouteAccessoryDTO("test", RouteAccessoryDTO.AccessoryType.PREDICATE);
        routeAccessoryDTO.setType(null);
        routeAccessoryDTO.setRouteId("test");

//        RouteDTO routeDTO1 = routeMapper.selectOne(new RouteDTO());
//        System.out.println(routeDTO1);
//            List<RouteAccessoryDTO> list = accessoryMapper.selectList(routeAccessoryDTO);
//            Map<RouteAccessoryDTO.AccessoryType, List<RouteAccessoryDTO>> map = list.stream().collect(Collectors.groupingBy(
//                    RouteAccessoryDTO::getType
//            ));
//            routeDTO1.setPredicates(map.get(RouteAccessoryDTO.AccessoryType.PREDICATE));
//            routeDTO1.setFilters(map.get(RouteAccessoryDTO.AccessoryType.FILTER));
//        log.info("{}", routeDTO1);
//        LoggerFactory.getLogger(getClass()).info("{}", routeDTO1);
//        Assert.assertNotNull(routeDTO1);
//        RouteAccessoryDTO routeAccessoryDTO = new RouteAccessoryDTO("test", RouteAccessoryDTO.AccessoryType.PREDICATE);
//        List<RouteAccessoryDTO> list = accessoryMapper.selectList(routeAccessoryDTO);
//        Assert.assertTrue(CollectionUtils.isNotEmpty(list));
    }
}