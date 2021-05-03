package com.example.Ecommercial.crud.order;

import com.example.Ecommercial.crud.customer.Customer;
import com.example.Ecommercial.crud.product.Product;
import com.example.Ecommercial.crud.warehouse.WareHouse;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    int id;

    @ManyToOne(targetEntity = WareHouse.class)
    WareHouse warehouse;

    @ManyToMany(targetEntity = Product.class)
    List<Product> products;

    @ManyToOne(targetEntity = Customer.class)
    Customer customer;
    LocalDateTime date;

    double totalPrice;
    boolean isDeleted;

    public Order() {
    }

    public Order(WareHouse warehouse, List<Product> product, Customer customer) {
        this.date=LocalDateTime.now();
        this.warehouse = warehouse;
        this.products = product;
        this.customer = customer;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WareHouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WareHouse warehouse) {
        this.warehouse = warehouse;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
