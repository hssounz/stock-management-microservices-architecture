package org.hssounz.inventoryservice.enities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.UUID;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Product {
    @Id
    private String id;
    private String name;
    private Double price;
    private int quantity;

    @PrePersist
    protected void onCreate() {
        this.id = UUID.randomUUID().toString();
    }
}
