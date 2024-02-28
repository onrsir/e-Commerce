package com.onursir.eCommerce.dataAccess;

import com.onursir.eCommerce.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
