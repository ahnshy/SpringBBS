package com.github.ahnshy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableSwagger2
//@SuppressWarnings("unchecked")
public class SwaggerConfig {

    private static final String API_TITLE = "SpringBBS API";
    private static final String API_VERSION = "1.0.0.0";
    private static final String API_DESCRIPTION = "SpringBBS API Guide";


    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2) // Swagger Doc Type
                .apiInfo(this.apiInfo()) // setter api info(title, description etc)
                .select()
                .apis(RequestHandlerSelectors.any()) // set package (Enable all request mapping or package name)
                .paths(PathSelectors.any()) // set path (Enable all path)
                .build()
                .pathMapping("/");
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version(API_VERSION)
                .build();
    }
}
