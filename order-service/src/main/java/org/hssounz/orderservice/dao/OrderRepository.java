package org.hssounz.orderservice.dao;

import org.hssounz.orderservice.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, String> {
}
