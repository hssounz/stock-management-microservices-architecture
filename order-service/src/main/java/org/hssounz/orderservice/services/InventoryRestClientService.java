package org.hssounz.orderservice.services;

import org.hssounz.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "inventory-service")
public interface InventoryRestClientService {
     @GetMapping("/products/{id}?projection=full-product")
     public Product productById(@PathVariable String id);
     @GetMapping("/products?projection=full-product")
     public PagedModel<Product> allProducts();
}
