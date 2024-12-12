package com.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Documentation")
                        .description("Spring Boot 3.4.0 REST API documentation with Swagger UI")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Rahul Warke")
                                .email("rahulwarke554@gmail.com")));
    }
}
