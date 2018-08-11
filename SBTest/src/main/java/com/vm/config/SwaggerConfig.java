/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 *
 * @author VINODH
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vm.controller"))
                .paths(regex("/api/.*"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
//        ApiInfo apiInfo = new ApiInfo(
//                "VM SMS API",
//                "SVM SMS REST API to send the Bulk Messages.",
//                "1.0","", new Contact("Admin", "www.vectramind.com", "info@vectramind.com"), "", "");
        ApiInfo apiInfo = new ApiInfo(
                "VM SMS API",
                "VM SMS REST API to send the Bulk Messages.",
                "1.0", "", "", "", "");
        return apiInfo;
    }

}
