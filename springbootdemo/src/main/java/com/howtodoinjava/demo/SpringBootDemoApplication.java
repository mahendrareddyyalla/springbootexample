package com.howtodoinjava.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration(exclude=ActiveMQAutoConfiguration.class)
@EnableJpaRepositories("com.howtodoinjava.demo.repository")
@EntityScan("com.howtodoinjava.demo.dao.entity")
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootDemoApplication.class, args);
ApplicationContext ctx = SpringApplication.run(SpringBootDemoApplication.class, args);
        
       /* String[] beanNames = ctx.getBeanDefinitionNames();
         
        Arrays.sort(beanNames);
 
        for (String beanName : beanNames) {
            System.out.println(beanName);
            
        }
 */  }
	
	}

