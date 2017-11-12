package com.sintecmedia.rc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

  ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Ratecard Micro Service Apis")
        .description(
            "Ratecard Rest API Documentation. All Ratecard APIs have been detailed in this documentation.")
        .license("Sintecmedia.com").licenseUrl("http:/http://www.sintecmedia.com/")
        .termsOfServiceUrl("").version("1.0")
        .contact(new Contact("", "", "ratecard-api-dev@sintecmedia.com")).build();
  }

  @Bean
  public Docket customImplementation() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.sintecmedia.rc")).build()
        // Disable default exception configured by swagger for all type of request method.
        .useDefaultResponseMessages(false).apiInfo(apiInfo());
  }
}
