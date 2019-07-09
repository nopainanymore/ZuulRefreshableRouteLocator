package com.nopainanymore.apigateway;


import com.nopainanymore.apigateway.filters.PreTestFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@MapperScan("com.nopainanymore.apigateway.dao")
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public PreTestFilter preTestFilter() {
        return new PreTestFilter();
    }
}

