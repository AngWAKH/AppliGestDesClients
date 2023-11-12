package com.ingse.appligestdesclients.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfiguration {
    @Bean
    public Docket apiClient(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(
                new ApiInfoBuilder()
                        .description("Gestion des Clients API Documentation")
                        .title("Gestion des Clients REST API")
                        .build()
        ).groupName("REST API V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ingse.appligestdesclients"))
                .build();

    }

}
