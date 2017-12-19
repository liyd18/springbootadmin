package com.wht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import de.codecentric.boot.admin.config.EnableAdminServer;


@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
@EnableAutoConfiguration
@ComponentScan("com.wht")
@ServletComponentScan
@EnableTurbine
public class AdminApplication {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
    	SpringApplication app = new SpringApplication(AdminApplication.class);
        Environment environment = app.run(args).getEnvironment();
    }

}
