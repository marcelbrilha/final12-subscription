package com.final12.final12subscription.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

	@Bean
	public Docket apiV1() {
		return new Docket(DocumentationType.SWAGGER_2)
			.groupName("v1")
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.final12.final12subscription.web.rest"))
			.build()
			.apiInfo(new ApiInfoBuilder().title("Final 12 - Subscrições").description("Microsserviço de Subscrições - Final 12").build());
	}
}
