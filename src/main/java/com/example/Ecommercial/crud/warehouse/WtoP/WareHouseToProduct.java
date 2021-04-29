package com.example.Ecommercial.crud.warehouse.WtoP;

import com.example.Ecommercial.crud.product.Product;
import com.example.Ecommercial.crud.warehouse.WareHouse;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class WareHouseToProduct {
    @Id
    int id;

    int qantity;

    @ManyToOne
    WareHouse wareHouse;

    @ManyToOne
    Product product;

    public WareHouseToProduct() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WareHouse getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQantity() {
        return qantity;
    }

    public void setQantity(int qantity) {
        this.qantity = qantity;
    }
}
