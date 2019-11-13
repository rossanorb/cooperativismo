package com.cooperativismo.ApiRest.config;


import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

import springfox.documentation.service.VendorExtension;
import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiConfigDocs() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.cooperativismo.ApiRest.resources.v1"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo infoDocs() {
		return new ApiInfo("Title - Rest API", "Sistema de Votação em assembleia", "1.0", "Terms",
				new Contact("Rossano", "https://localhost.com", "rossanorb@gmail.com"), "Apache License", "Url",
				new ArrayList<VendorExtension>());
	}
	
}
