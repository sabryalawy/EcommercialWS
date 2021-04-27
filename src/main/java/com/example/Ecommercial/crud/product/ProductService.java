package com.example.Ecommercial.crud.product;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductService {

    @Autowired
    ProductRepo products;

    @RequestMapping(method = RequestMethod.POST,value = "/product")
    public String addProduct(@RequestBody Product product){
        try{
            products.save(product);

            return new Gson().toJson(product)+" has been added";
        }catch (Exception e){
            return "something error please make sure that the data is correct";
        }
    }

    @RequestMapping("/product")
    public String getProduct(){
        try {
            List<Product> rez= new ArrayList<>();
            List<Product> theProducs= (List<Product>) products.findAll();
            for (Product p:theProducs){
                if (!p.isDeleted()){
                    rez.add(p);
                }
            }
            return new Gson().toJson(rez);
        }catch (Exception e){
            return "somtheing error please return";
        }
    }

    //still need get by id
    //still need softdeleted
    //still need update
}
