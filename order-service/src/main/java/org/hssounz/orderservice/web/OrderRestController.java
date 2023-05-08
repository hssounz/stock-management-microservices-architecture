package org.hssounz.orderservice.web;

import org.hssounz.orderservice.dao.OrderRepository;
import org.hssounz.orderservice.dao.ProductItemRepository;
import org.hssounz.orderservice.entities.Order;
import org.hssounz.orderservice.services.CustomerRestClientService;
import org.hssounz.orderservice.services.InventoryRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {
    private final OrderRepository orderRepository;
    private final ProductItemRepository productItemRepository;
    private final CustomerRestClientService customerRestClientService;
    private final InventoryRestClientService inventoryRestClientService;

    public OrderRestController(
            OrderRepository orderRepository,
            ProductItemRepository productItemRepository,
            CustomerRestClientService customerRestClientService,
            InventoryRestClientService inventoryRestClientService
    ) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClientService = customerRestClientService;
        this.inventoryRestClientService = inventoryRestClientService;
    }

    @GetMapping("/orders/{id}/details")
    public Order getOrder(@PathVariable String id){
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Order %s not found", id))
        );
        order.setCustomer(
                customerRestClientService.customerById(
                        order.getCustomerId()
                )
        );
        order.getProductItems().forEach(
                productItem -> productItem.setProduct(
                        inventoryRestClientService.productById(
                                productItem.getId()
                        )
                )
        );
        return order;
    }
}
