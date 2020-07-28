package com.howtodoinjava.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
//@Profile("!test")
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
    public Docket apiDocket() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.howtodoinjava.demo.controller"))      //RequestHandlerSelectors.any()        
          .paths(PathSelectors.any())                          
          .build();                                           
    }
}
	
    /*@Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().title("employee service").build())
                .enableUrlTemplating(false)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.howtodoinjava.demo.controller"))
                .build();
    }

    *//**
     * The {@link SecurityScheme} to be used.
     *
     * @return The {@link SecurityScheme} to be used.
     *//*
    @Bean
    public SecurityScheme oauth() {
        return new OAuthBuilder()
                .name("OAuth2")
                .scopes(scopes())
                .grantTypes(grantTypes())
                .build();
    }

    *//**
     * The {@link GrantType}s for the Service.
     *
     * @return The {@link GrantType}s for the Service.
     *//*
    @Bean
    public List<GrantType> grantTypes() {
        String oauthServerUri = tokenInfoUri.substring(0, tokenInfoUri.lastIndexOf("/check_token"));
        TokenRequestEndpoint tokenRequestEndpoint =
                new TokenRequestEndpoint(oauthServerUri + "/oauth/authorize", clientId, clientSecret);
        TokenEndpoint tokenEndpoint = new TokenEndpoint(oauthServerUri + "/oauth/token", "token");
        return Collections.singletonList(new AuthorizationCodeGrant(tokenRequestEndpoint, tokenEndpoint));
    }

    *//**
     * {@link SecurityConfiguration} for the Swagger.
     *
     * @return {@link SecurityConfiguration} for Swagger.
     *//*
    @Bean
    public SecurityConfiguration securityInfo() {
        return new SecurityConfiguration("employee-client-swagger", "employee-client-swagger", "employee-uaa",
                "employee-swagger", "apiKey", ApiKeyVehicle.HEADER, "api_key", "");
    }

    *//**
     * The {@link AuthorizationScope}s for the service.
     *
     * @return {@link AuthorizationScope}s for the Service.
     *//*
    private List<AuthorizationScope> scopes() {
        List<AuthorizationScope> list = new ArrayList<>();
        list.add(new AuthorizationScope("employee.read", "Grants read access"));
        list.add(new AuthorizationScope("employee.write", "Grants write access"));
        return list;
    }

}*/