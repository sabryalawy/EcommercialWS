package com.example.Ecommercial.crud.product;

import com.example.Ecommercial.crud.warehouse.WtoP.WareHouseToProduct;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue
    @Expose
    int id;
    @Expose
    String name;
    @Expose
    String brand;
    @Expose
    String serial;
    @Expose
    boolean isDeleted;

    public Product() {
    }

    public Product(int id, String name, String brand, String serial) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.serial = serial;
    }

    public Product(int id, String name, String brand, String serial, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.serial = serial;
        this.isDeleted = isDeleted;
    }

    public Product(String name, String brand, String serial, boolean isDeleted) {
        this.name = name;
        this.brand = brand;
        this.serial = serial;
        this.isDeleted = isDeleted;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }


}
