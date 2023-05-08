package org.hssounz.orderservice.dao;

import org.hssounz.orderservice.entities.ProductItem;
import org.springframework.data.repository.CrudRepository;

public interface ProductItemRepository extends CrudRepository<ProductItem, String > {
}
