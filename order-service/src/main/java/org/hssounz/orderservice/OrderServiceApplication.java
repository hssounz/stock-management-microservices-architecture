package org.hssounz.orderservice;

import org.hssounz.orderservice.dao.OrderRepository;
import org.hssounz.orderservice.dao.ProductItemRepository;
import org.hssounz.orderservice.entities.Order;
import org.hssounz.orderservice.entities.ProductItem;
import org.hssounz.orderservice.enums.OrderStatus;
import org.hssounz.orderservice.model.Customer;
import org.hssounz.orderservice.model.Product;
import org.hssounz.orderservice.services.CustomerRestClientService;
import org.hssounz.orderservice.services.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

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
			List<Customer> customers = customerRestClientService.allCustomers().getContent().stream().toList();
			List<Product> products = inventoryRestClientService.allProducts().getContent().stream().toList();

			for (int i = 0; i < 20; i++) {
				Order order = Order.builder()
						.customerId(customers.get(new Random().nextInt(customers.size())).getId())
						.status(Math.random() < 0.5 ? OrderStatus.PENDING : OrderStatus.CREATED)
						.build();
				orderRepository.save(order);
				for (Product product : products) {
					if (Math.random() > 0.6) {
						ProductItem productItem = ProductItem.builder()
								.order(order)
								.productId(product.getId())
								.quantity(1 + (int) (Math.random() * 9))
								.discount(Math.random() * 100)
								.build();

						productItem
								.setPrice(
										productItem.getQuantity() * inventoryRestClientService
												.productById(productItem.getProductId())
												.getPrice()
								);
						productItemRepository.save(productItem);
					}
				}
			}
		};
	}

}
