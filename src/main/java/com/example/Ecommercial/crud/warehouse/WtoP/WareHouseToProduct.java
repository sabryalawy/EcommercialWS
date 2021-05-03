package com.example.Ecommercial.crud.warehouse.WtoP;

import com.example.Ecommercial.crud.product.Product;
import com.example.Ecommercial.crud.warehouse.WareHouse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class WareHouseToProduct {
    @Id
    @GeneratedValue
    int id;

    int qantity;


    int wareHouse;


    int product;

    boolean isDeleted;

    public WareHouseToProduct() {
    }

    public WareHouseToProduct(int wareHouse, int product) {
        this.wareHouse = wareHouse;
        this.product = product;
    }

    public WareHouseToProduct(int qantity, int wareHouse, int product) {
        this.qantity = qantity;
        this.wareHouse = wareHouse;
        this.product = product;
    }

    public WareHouseToProduct(int id, int qantity, int wareHouse, int product) {
        this.id = id;
        this.qantity = qantity;
        this.wareHouse = wareHouse;
        this.product = product;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(int wareHouse) {
        this.wareHouse = wareHouse;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getQantity() {
        return qantity;
    }

    public void setQantity(int qantity) {
        this.qantity = qantity;
    }
}
