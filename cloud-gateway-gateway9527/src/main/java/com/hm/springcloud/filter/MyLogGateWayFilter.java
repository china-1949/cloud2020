package com.hm.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * 自定义全局GlobalFilter
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*******com in MyLogGateWayFilter:" +new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(null==uname){ //非法用户判断
            log.info("********用户名为null，非法用户，o(╥﹏╥)o");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange); //合法放行，进入下一个过滤链
    }

    @Override
    public int getOrder() {  //越小优先级越高！！ int HIGHEST_PRECEDENCE = -2147483648;int LOWEST_PRECEDENCE = 2147483647;

        return 0;
    }
}
