package com.onursir.eCommerce.dataAccess;

import com.onursir.eCommerce.Entity.User;
import com.onursir.eCommerce.business.responses.GetAllUserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.orders WHERE u.id = :userId")
    GetAllUserResponse getUserWithOrders(@Param("userId") Long userId);

    User findByOrdersId(long orderId);

}
