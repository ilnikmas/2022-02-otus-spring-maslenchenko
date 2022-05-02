package ru.otus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ru.otus.service.ResourceConnection;

@Configuration
public class ApplicationConfig {

    @Bean
    public Resource resource() {
        return new ClassPathResource("questions.csv");
    }

    @Bean
    public ResourceConnection connection() {
        return new ResourceConnection();
    }

}
