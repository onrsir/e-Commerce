package com.onursir.eCommerce.dataAccess;

import com.onursir.eCommerce.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
