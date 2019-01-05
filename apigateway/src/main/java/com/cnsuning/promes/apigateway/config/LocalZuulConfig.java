package com.cnsuning.promes.apigateway.config;

import com.cnsuning.promes.apigateway.RedisRouteLocator;
import com.cnsuning.promes.apigateway.service.LocalRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * apigateway: RefreshableZuulConfig
 *
 * @author 李旺 (Employee ID: 18070881)
 * @version 1.0.0, 2019-01-05 09:57
 * @since 1.0.0, 2019-01-05 09:57
 */
@Configuration
public class LocalZuulConfig {

    @Autowired
    ZuulProperties zuulProperties;

    @Autowired
    ServerProperties serverProperties;

    @Autowired
    LocalRouteService localRouteService;

    @Bean
    public RedisRouteLocator refreshRouteLocator() {
        RedisRouteLocator redisRouteLocator = new RedisRouteLocator("server" , this.zuulProperties);
        redisRouteLocator.setLocalRouteService(localRouteService);
        return redisRouteLocator;
    }

}
