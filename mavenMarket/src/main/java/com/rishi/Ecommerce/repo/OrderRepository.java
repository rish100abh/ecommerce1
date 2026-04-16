package com.rishi.Ecommerce.repo;

import com.rishi.Ecommerce.model.Orders;
import com.rishi.Ecommerce.model.User;
import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Long> {

    @Query("Select o from Orders o Join FETCH o.user")
    List<Orders> findAllOrdersWithUsers();


    List<Orders> findByUser(User user);
}
