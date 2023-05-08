package org.hssounz.inventoryservice;

import org.hssounz.inventoryservice.dao.ProductRepository;
import org.hssounz.inventoryservice.enities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args -> {
			productRepository.saveAll(List.of(
					Product.builder().name("Iphone 8 Plus").price(900D).quantity(3).build(),
					Product.builder().name("Iphone X").price(1100D).quantity(6).build(),
					Product.builder().name("Iphone Xs Max").price(1600D).quantity(1).build(),
					Product.builder().name("Iphone 12").price(2000D).quantity(12).build(),
					Product.builder().name("Iphone 12 Pro").price(2400D).quantity(8).build(),
					Product.builder().name("Iphone 12 Pro Max").price(2600D).quantity(15).build(),
					Product.builder().name("Iphone 13 Pro").price(2900D).quantity(10).build(),
					Product.builder().name("Iphone 13 Pro Max").price(3200D).quantity(8).build()
			));
		};
	}
}
