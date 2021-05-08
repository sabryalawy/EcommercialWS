package com.example.Ecommercial.crud.customer;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class CustomerService {

    @Autowired
    CustomerRepo customers;

    @RequestMapping(method = RequestMethod.POST, value = "/customer")
    public String addCustomer(@RequestParam Map<String,String> customer){
        Gson g= new Gson();
        Customer customerz=g.fromJson((String) customer.keySet().toArray()[0],Customer.class);
        customers.save(customerz);
        return customer+" has been added";
    }

    //getting customers that are not deleted
    @RequestMapping("/customer")
    public String getCustomers(){
        Gson gson= new Gson();
        List <Customer> rez=new ArrayList<>();
        List<Customer> customersNotDeleted = (List<Customer>) customers.findAll();
        for (Customer c:customersNotDeleted){
            if (!c.isDeleted){
                rez.add(c);
            }
        }
        String rezCustomers=gson.toJson(rez);
        return rezCustomers;
    }

    //get all customers even the deleted
    @RequestMapping("/customer/getallcustomers")
    public String allCustomers(){
        Gson g= new Gson();
        return g.toJson(customers.findAll());
    }

    @RequestMapping("/customer/{id}")
    public String getCustomer(@PathVariable int id){
        Gson g= new Gson();
        return g.toJson(customers.findById(id).get());
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/customer/{id}")
    public String deleteCustomer(@PathVariable int id){
        try{
            Customer c= customers.findById(id).get();
            c.setDeleted(true);
            customers.save(c);
        }catch (Exception e){
            return "make sure that the id is avalable";
        }
        return "null;";
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/customer/{id}")
    public String updateCustomer(@PathVariable int id ,@RequestBody Customer customer){
        Customer temp=customers.findById(id).get();
        if (!customer.getUserName().isEmpty()){
            temp.setUserName(customer.getUserName());
        }
        if(!customer.getPassword().isEmpty()){
            temp.setPassword(customer.getPassword());
        }
        if(!customer.getfName().isEmpty()){
            temp.setfName(customer.getfName());
        }
        if (!customer.getlName().isEmpty()){
            temp.setlName(customer.getlName());
        }
        customers.save(temp);
        return temp+" have been updated";
    }
}
