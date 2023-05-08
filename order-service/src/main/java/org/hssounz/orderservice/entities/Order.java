package org.hssounz.orderservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hssounz.orderservice.enums.OrderStatus;
import org.hssounz.orderservice.model.Customer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity @Table(name = "orders")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Order {
    @Id
    private String id;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private OrderStatus status;
    private String  customerId;
    @Transient
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;

    @PrePersist
    private void creation(){
        this.id = UUID.randomUUID().toString();
    }
}
