package com.nopainanymore.apigateway.config;


import com.nopainanymore.apigateway.MyRouteLocator;
import com.nopainanymore.apigateway.service.MyRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * apigateway: RefreshableZuulConfig
 *
 * @author nopainanymore
 * @version 1.0.0, 2019-01-05 09:57
 * @since 1.0.0, 2019-01-05 09:57
 */
@Configuration
public class MyZuulConfig {

    private final ZuulProperties zuulProperties;

    private final ServerProperties serverProperties;

    private final MyRouteService myRouteService;

    @Autowired
    public MyZuulConfig(ZuulProperties zuulProperties, ServerProperties serverProperties, MyRouteService myRouteService) {
        this.zuulProperties = zuulProperties;
        this.serverProperties = serverProperties;
        this.myRouteService = myRouteService;
    }

    @Bean
    public MyRouteLocator refreshRouteLocator() {
        MyRouteLocator redisRouteLocator = new MyRouteLocator("server", this.zuulProperties);
        redisRouteLocator.setMyRouteService(myRouteService);
        return redisRouteLocator;
    }

}
