package com.howtodoinjava.demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.howtodoinjava.demo.dao.entity.EmployeeEntity;
import com.howtodoinjava.demo.repository.EmployeeRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = EmployeeRepository.class)
@EntityScan(basePackageClasses = EmployeeEntity.class)
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableTransactionManagement
public class JpaConfiguration {

    /**
     * Register a {@link AuditorAware} which returns "SYSTEM" for the moment until security contexts can be set up.
     *
     * @return Temporary {@link AuditorAware}
     */
    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> "SYSTEM";
    }

}

