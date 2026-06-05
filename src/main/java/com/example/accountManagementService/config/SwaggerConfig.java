package com.example.accountManagementService.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI accountManagementAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Account Management Service API")
                        .description("REST API for Account Management")
                        .version("1.0")
                        .contact(new Contact()
                                .name("KOUSHIK KOLLA")
                                .email("koushikkolla51@gmail.com")));
    }
}