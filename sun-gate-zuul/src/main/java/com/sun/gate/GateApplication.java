package com.sun.gate;

import com.sun.gate.filters.RequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
public class GateApplication {

    public static void main(String... args) {
        SpringApplication.run(GateApplication.class, args);
    }
    @Bean
    public RequestLogFilter logger() {
        return new RequestLogFilter();
    }
}
