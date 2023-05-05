package com.springboot.jpa.SpringBootAssignmentFirst.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayDeque;

@Configuration
public class SwaggerConfig {

    @Bean
      public Docket docket(){
          Docket docket = new Docket(DocumentationType.SWAGGER_2);
          docket.apiInfo(getAPiInfo());
          return docket;
      }

    private ApiInfo getAPiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "ems : ApI's",
                "this is backend project",
                "1.0.0.v",
                "https://www.flipkart.com/",
                new Contact("Priyanka","https://www.amazon.in/","er.guptapriyanka1991@gmail.com"),
        "licensse of APis",
        "https://www.flipkart.com/about",
                new ArrayDeque<>()
        );
        return apiInfo;
    }
}
