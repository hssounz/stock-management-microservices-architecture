package org.hssounz.inventoryservice.enities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Product.class, name = "full-product")
public interface ProductProjection {
    String getId();
    String getName();
    Double getPrice();
    int getQuantity();
}
