package com.tacknine.ums.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().addSecurityItem(
                new SecurityRequirement().addList("auth")).components(new Components()
                .addSecuritySchemes("auth", new SecurityScheme().name("auth")
                        .type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));

    }
}
