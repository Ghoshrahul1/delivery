package com.shopping.delivery.Repository;

import com.shopping.delivery.Entity.ProductDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetails extends JpaRepository<ProductDetailsEntity,Long> {
}
