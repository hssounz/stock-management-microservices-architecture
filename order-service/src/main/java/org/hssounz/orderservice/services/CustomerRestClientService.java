package org.hssounz.orderservice.services;

import org.hssounz.orderservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "customer-service")
public interface CustomerRestClientService {

     @GetMapping("/customers/{id}?projection=full-customer")
     public Customer customerById(@PathVariable String id);
     @GetMapping("/customers?projection=full-customer")
     public PagedModel<Customer> allCustomers();
}
