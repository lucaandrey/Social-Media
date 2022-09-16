package com.generation.blogpessoal.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI springBlogPessoalOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Projeto Blog Pessoal")
						.description("Projeto Blog Pessoal - Luca Costa")
						.version("v0.0.1")
				.license(new License()
						.name("Meu LinkedIn")
						.url("https://www.linkedin.com/in/lucaandrey"))
				.contact(new Contact()
						.name("Meu GitHub")
						.url("https://github.com/lucaandrey")
						.email("lucaandrey5@hotmail.com")))
				.externalDocs(new ExternalDocumentation()
						.description("Repositorio do projeto!")
						.url("https://github.com/lucaandrey/Social-Media"));
	}
	
	@Bean
	public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {
		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation ->{
				
				ApiResponses apiResponses = operation.getResponses();
				
				apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
				apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				apiResponses.addApiResponse("204", createApiResponse("Objeto Excluido!"));
				apiResponses.addApiResponse("400", createApiResponse("Erro na Requisicao!"));
				apiResponses.addApiResponse("401", createApiResponse("Acesso Nao Autorizado!"));
				apiResponses.addApiResponse("404", createApiResponse("Objeto Nao Encontrado!"));
				apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicacao!"));
				
			}));
		};
	}
	
	private ApiResponse createApiResponse(String message) {
		
		return new ApiResponse().description(message);
	}
	
	
}
