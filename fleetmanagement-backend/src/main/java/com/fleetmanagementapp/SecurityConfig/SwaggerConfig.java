package com.fleetmanagementapp.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rest_api"))
                .paths(PathSelectors.any())
                .build();
    }

    private List<Parameter> globalParameterList() {
        Parameter authTokenHeader =
                new ParameterBuilder()
                        .name("Authorization") // name of the header
                        .modelRef(new ModelRef("string"))
                        .required(false)
                        .parameterType("header")
                        .description("Bearer <token>")
                        .build();

        return Collections.singletonList(authTokenHeader);
    }


}