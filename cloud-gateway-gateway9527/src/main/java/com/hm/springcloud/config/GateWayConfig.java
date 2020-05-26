package com.hm.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig { //https://news.baidu.com/guonei
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu",r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei")).build();
        return  routes.build();

        //访问localhost:9527/guonei  映射到 http://news.baidu.com/guonei 地址
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu",r -> r.path("/guoji")
                .uri("http://news.baidu.com/guoji")).build();
        return  routes.build();

        //访问localhost:9527/guoji  映射到 http://news.baidu.com/guoji 地址
    }
}

