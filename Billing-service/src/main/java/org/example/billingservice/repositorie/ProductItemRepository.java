package org.example.billingservice.repositorie;

import org.example.billingservice.entitie.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
