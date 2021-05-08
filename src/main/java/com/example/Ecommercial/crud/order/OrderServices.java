package com.example.Ecommercial.crud.order;

import com.example.Ecommercial.crud.customer.Customer;
import com.example.Ecommercial.crud.customer.CustomerRepo;
import com.example.Ecommercial.crud.product.Product;
import com.example.Ecommercial.crud.product.ProductRepo;
import com.example.Ecommercial.crud.warehouse.WareHouse;
import com.example.Ecommercial.crud.warehouse.WareHouseRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class OrderServices {

    @Autowired
    OrderRepo orders;

    @Autowired
    WareHouseRepo wareHouses;

    @Autowired
    ProductRepo products;

    @Autowired
    CustomerRepo customers;

    @RequestMapping(method = RequestMethod.POST,value = "/order")
    public String addOrder(@RequestParam Map<String, String> orderss){
        Gson g= new Gson();
        Order order=g.fromJson((String) orderss.keySet().toArray()[0],Order.class);
            order.setDate(LocalDateTime.now());
            double tootalprice=0;
            for (Product i:order.getProducts()){
                i=products.findById(i.getId()).get();
                tootalprice+=i.getPrice();
            }
            order.setTotalPrice(tootalprice);
            orders.save(order);
            return "Done!";
    }

    @RequestMapping("order")
    public String getOrders(){
        List <Order>a= (List) orders.findAll();

        System.out.println(a.get(0).getWarehouse());
        return new Gson().toJson(orders.findAll());
    }

    @RequestMapping("/order/{id}")
    public String getOrder(@PathVariable int id){
        return new Gson().toJson(orders.findById(id));
    }

    @RequestMapping("/order/customerorders/{cid}")
    public String getCustomerOrders(@PathVariable int cid){
        return new Gson().toJson(orders.findByCustomerId(cid));
    }
}
