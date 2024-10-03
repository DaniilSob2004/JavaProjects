package com.example.AutoBase;

import com.example.AutoBase.service.AutoBaseInitializer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
public class AppStarter {

    @Autowired
    private AutoBaseInitializer autoBaseInitializer;

    @Bean
    public ApplicationRunner init() {
        log.info("ApplicationRunner has started");
        return args -> {
            System.out.println("-".repeat(20));
            autoBaseInitializer.autoBaseInitialize();
            System.out.println("-".repeat(20));
        };
    }
}
