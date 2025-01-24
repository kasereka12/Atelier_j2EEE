package org.example.inventoryservice;

//import org.example.inventoryservice.config.CustomerConfigParam;
import org.example.inventoryservice.entitie.Product;
import org.example.inventoryservice.repositorie.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.UUID;

@SpringBootApplication
//@EnableConfigurationProperties(CustomerConfigParam.class)
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProductRepository productRepository , RepositoryRestConfiguration restConfiguration){
		return (args -> {
				restConfiguration.exposeIdsFor(Product.class);
				for (int i = 0 ; i < 50 ; i++){
					Product product = Product
							.builder()
							.id(UUID.randomUUID().toString())
							.nom("produit")
							.description("description")
							.prix(1000+Math.random()*100)
							.build();

					productRepository.save(product);
				}
		});
	}
}
