filter和predicate的名字来源
xxxGatewayFilterFactory.getClass().getSimpleName()减去
GatewayFilterFactory.getClass().getSimpleName()
参考这个方法org.springframework.cloud.gateway.support.NameUtils.normalizeFilterFactoryName