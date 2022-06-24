package com.example.app_service.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean(name = "appServiceOpenApi")
    public OpenAPI appServicesOpenApi(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("appService Application API")
                        .description("appService API"));
    }
}
