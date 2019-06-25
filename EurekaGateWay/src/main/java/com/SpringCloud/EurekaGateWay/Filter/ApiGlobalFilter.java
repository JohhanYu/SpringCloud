package com.SpringCloud.EurekaGateWay.Filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
public class ApiGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        ServerHttpResponse response = exchange.getResponse();
        if(StringUtils.isBlank(token)){
            response = exchange.getResponse();
            Map<String,Object> message = new HashMap<>();
            message.put("status", -1);
            message.put("data", "鉴权失败");
            byte[] bits = message.toString().getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(bits);
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.getHeaders().add("Content-Type", "text/json;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));
        }else if(token.equals("1234")==false){
            Map<String,Object> messageFalse = new HashMap<>();
            //封装返回状态信息
            messageFalse.put("status",-1);
            messageFalse.put("data","你无权访问!");
            //将messageFalse转换为字节数组
            byte[] bits = messageFalse.toString().getBytes(StandardCharsets.UTF_8);
            //将字节数组放进字符流
            DataBuffer bufferFalse = response.bufferFactory().wrap(bits);
            //封装请求状态吗以及请求头
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.getHeaders().add("Content-Type", "text/json;charset=UTF-8");
            //通过Mono将数据返回给前端
            return response.writeWith(Mono.just(bufferFalse));
        }
        return chain.filter(exchange);
    }
}
