package org.hssounz.customerservice;

import org.hssounz.customerservice.dao.CustomerRepository;
import org.hssounz.customerservice.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			Stream.of("Hassen", "Leila", "Amira", "Mohamed", "Fares").forEach(
					name -> customerRepository.save(
								Customer.builder()
										.name(name)
										.email(name + "@gmail.com")
										.build()
					)
			);
		};
	}

}
