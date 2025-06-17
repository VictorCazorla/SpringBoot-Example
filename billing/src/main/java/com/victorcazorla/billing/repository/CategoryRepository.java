package com.victorcazorla.billing.repository;

import com.victorcazorla.billing.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
