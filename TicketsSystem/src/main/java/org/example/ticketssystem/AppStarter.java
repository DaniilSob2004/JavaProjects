package org.example.ticketssystem;

import lombok.extern.log4j.Log4j2;
import org.example.ticketssystem.menu.StartMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
public class AppStarter {

    @Autowired
    private StartMenu startMenu;

    @Bean
    public ApplicationRunner init() {
        log.info("ApplicationRunner has started");
        return args -> {
            System.out.println("-".repeat(20));

            startMenu.start();

            System.out.println("-".repeat(20));
        };
    }
}
