package org.hssounz.customerservice.entities;

import org.hssounz.customerservice.entities.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "full-customer", types = Customer.class)
public interface CustomerProjection {
    String getId();
    String getName();
    String getEmail();
}
