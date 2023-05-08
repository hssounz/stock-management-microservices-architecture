package org.hssounz.orderservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hssounz.orderservice.model.Product;

import javax.persistence.*;
import java.util.UUID;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductItem {
    @Id
    private String id;
    private String productId;
    @Transient
    private Product product;
    private Double price;
    private int quantity;
    private Double discount;
    @ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order order;

    @PrePersist
    private void creation(){
        this.id = UUID.randomUUID().toString();
    }
}
