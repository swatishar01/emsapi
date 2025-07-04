package com.example.emsapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Contact contact = new Contact();
        contact.setEmail("info@example.com");
        contact.setName("EMS API Support");
        contact.setUrl("https://example.com");

        License license = new License()
            .name("Apache License, Version 2.0")
            .url("https://www.apache.org/licenses/LICENSE-2.0");

        Info info = new Info()
            .title("Employee Management System API")
            .version("1.0.0")
            .contact(contact)
            .description("This API exposes endpoints for managing employees.")
            .license(license);

        return new OpenAPI().info(info);
    }
}
