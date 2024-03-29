package com.ming.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ming.data.controller"))
                .build();

    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("","","");
        return new ApiInfo(
                "Swagger学习",
                "配置Swagger",
                "v1.0",
                "",
                "contact",
                "Apach2.0",
                "许可链接"
        );
    }
}