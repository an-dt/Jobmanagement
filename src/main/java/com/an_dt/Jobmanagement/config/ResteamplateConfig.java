package com.an_dt.Jobmanagement.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class ResteamplateConfig implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ResteamplateConfig.applicationContext = applicationContext;
    }

}

