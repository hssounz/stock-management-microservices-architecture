package org.hssounz.inventoryservice.dao;

import org.hssounz.inventoryservice.enities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, String > {
}
