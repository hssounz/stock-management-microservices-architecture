package org.hssounz.customerservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;

    @PrePersist
    private void creation(){
        this.id = UUID.randomUUID().toString();
    }
}
