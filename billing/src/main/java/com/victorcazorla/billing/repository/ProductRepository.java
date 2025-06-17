package com.victorcazorla.billing.repository;

import com.victorcazorla.billing.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
