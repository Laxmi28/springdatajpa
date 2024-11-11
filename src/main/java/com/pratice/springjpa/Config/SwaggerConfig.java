package com.pratice.springjpa.Config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI customOpenAPISpec(){
            return new OpenAPI().info(new Info().title("Education Management"))
            .servers(Arrays.asList(new Server().url("http://localhost:8080/").description("Local environment")
            , new Server().url("http://localhost:8082/").description("Live Environment"))
           
            );
          
    }
}
