package com.vivi.bugTracking;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.any;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
    @Bean
    public Docket butTrackingApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vivi.bugTracking.controller"))
                .paths(any())
//                .paths(regex("/api/*"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "BugTracking Rest Api",
                "BugTracking Rest Api",
                "1.0",
                "Terms of service",
                new Contact("Meng Sun", "http://www.nowebsite.com", "nomail@abc.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
        return apiInfo;
    }

    private ApiKey apiKey() {
        return new ApiKey("AUTHORIZATION", "Authorization", "header");
    }

    @Bean
    SecurityConfiguration security() {
        return new SecurityConfiguration(
                null,
                null,
                null, // realm Needed for authenticate button to work
                null, // appName Needed for authenticate button to work
                "BEARER ",// apiKeyValue
                ApiKeyVehicle.HEADER,
                "AUTHORIZATION", //apiKeyName
                null);
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(
                new SecurityReference("AUTHORIZATION", authorizationScopes));
    }

}
