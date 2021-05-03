package com.example.Ecommercial.crud.order;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepo extends CrudRepository<Order,Integer> {

    public List<Order> findByCustomerId(int customer);


}
