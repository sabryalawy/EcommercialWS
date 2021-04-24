package com.example.Ecommercial.crud.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    int id;
    String userName;
    String password;
    String fName;
    String lName;
    boolean isDeleted=false;

    public Customer() {
    }

    public Customer(int id, String userName, String password, String fName, String lName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
    }

    public Customer(int id, String userName, String password, String fName, String lName, boolean isDeleted) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
