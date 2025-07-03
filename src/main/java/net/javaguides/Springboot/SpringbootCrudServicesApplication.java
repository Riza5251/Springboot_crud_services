package net.javaguides.Springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="SpringBoot API Documentation",
							   description=	"SpringBoot Rest API Documentation",
								version = "v1.0",
                                contact = @Contact(name = "Riza",email = "rizaqureshi5251@gmail.com",
								url = "https://www.google.com"),
                                license = @License(name = "Apache 2.0",
												url="https://www.google.com")),
									externalDocs = @ExternalDocumentation(description = "User Management API Documentation")
	)
public class SpringbootCrudServicesApplication {

	@Bean
	public ModelMapper modelMapper()
	{
		return new  ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudServicesApplication.class, args);
	}

}
