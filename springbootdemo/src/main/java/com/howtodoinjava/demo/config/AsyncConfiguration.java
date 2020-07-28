package com.howtodoinjava.demo.config;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class AsyncConfiguration extends AsyncConfigurerSupport {

    /**
     * {@inheritDoc}.
     */
    @Override
    public Executor getAsyncExecutor() {
        return new ThreadPoolExecutor(10, 100, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }
}