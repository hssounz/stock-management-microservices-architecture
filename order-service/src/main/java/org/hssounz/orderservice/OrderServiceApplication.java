package org.hssounz.orderservice;

import org.hssounz.orderservice.dao.OrderRepository;
import org.hssounz.orderservice.dao.ProductItemRepository;
import org.hssounz.orderservice.services.CustomerRestClientService;
import org.hssounz.orderservice.services.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(
			OrderRepository orderRepository,
			ProductItemRepository productItemRepository,
			CustomerRestClientService customerRestClientService,
			InventoryRestClientService inventoryRestClientService
	){
		return args -> {
			customerRestClientService.allCustomers().getContent().forEach(System.out::println);
			inventoryRestClientService.allProducts().getContent().forEach(System.out::println);
		};
	}

}
