package com.example.Ecommercial.crud.warehouse;

import com.example.Ecommercial.crud.warehouse.WtoP.WareHouseToProduct;
import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class WareHouse {
    @Id
    @GeneratedValue
    @Expose
    int id;
    @Expose
    String address;
    @Expose
    String city;
    @Expose
    String phoneNO;
    @Expose
    double capacity;
    @Expose
    boolean isDeleted;

    @OneToMany(mappedBy = "wareHouse")
    List<WareHouseToProduct> wareHouseToProduct;

    public WareHouse() {
    }

    public WareHouse(int id, String address, String city, String phoneNO, double capacity) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.phoneNO = phoneNO;
        this.capacity = capacity;
    }

    public WareHouse(int id, String address, String city, String phoneNO, double capacity, List<WareHouseToProduct> wareHouseToProduct) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.phoneNO = phoneNO;
        this.capacity = capacity;
        this.wareHouseToProduct = wareHouseToProduct;
    }

    public WareHouse(int id, String address, String city, String phoneNO, double capacity, boolean isDeleted, List<WareHouseToProduct> wareHouseToProduct) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.phoneNO = phoneNO;
        this.capacity = capacity;
        this.isDeleted = isDeleted;
        this.wareHouseToProduct = wareHouseToProduct;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public List<WareHouseToProduct> getWareHouseToProduct() {
        return wareHouseToProduct;
    }

    public void setWareHouseToProduct(List<WareHouseToProduct> wareHouseToProduct) {
        this.wareHouseToProduct = wareHouseToProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}
