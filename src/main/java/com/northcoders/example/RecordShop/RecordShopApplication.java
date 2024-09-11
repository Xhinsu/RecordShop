package com.northcoders.example.RecordShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class RecordShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecordShopApplication.class, args);

	}

	@Bean
	public OpenAPI todoApiInfo(){
		return new OpenAPI()
				.info(new Info().title("record shop")
						.version("v1")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
