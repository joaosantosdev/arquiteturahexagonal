package br.com.ourmind.loadbalancerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class LoadBalancerServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoadBalancerServerApplication.class, args);
    }
}
