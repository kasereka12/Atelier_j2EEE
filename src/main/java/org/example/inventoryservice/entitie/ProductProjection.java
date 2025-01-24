package org.example.inventoryservice.entitie;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullProduct" , types = Product.class)
public interface ProductProjection {
    public String getId();
    public String getNom();
    public double getPrix();
}
