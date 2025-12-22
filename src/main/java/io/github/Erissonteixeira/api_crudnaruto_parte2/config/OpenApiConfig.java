package io.github.Erissonteixeira.api_crudnaruto_parte2.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI ninjaApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Naruto - Ninjas")
                        .description("API para gerenciamento de ninjas do universo Naruto")
                        .version("v1"));
    }
}