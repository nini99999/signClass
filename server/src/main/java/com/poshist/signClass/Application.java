package com.poshist.signClass;

import org.apache.catalina.connector.Connector;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableRabbit
@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args)  {
        SpringApplication.run(Application.class, args);
    }

}
