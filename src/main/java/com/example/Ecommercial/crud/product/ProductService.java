package com.example.Ecommercial.crud.product;

import com.example.Ecommercial.crud.warehouse.WareHouse;
import com.example.Ecommercial.crud.warehouse.WareHouseRepo;
import com.example.Ecommercial.crud.warehouse.WtoP.WareHouseToProduct;
import com.example.Ecommercial.crud.warehouse.WtoP.WareHouseToProuductRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductService {

    @Autowired
    ProductRepo products;
    @Autowired
    WareHouseToProuductRepo wPR;

    @Autowired
    WareHouseRepo wareHouses;

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



    @RequestMapping(method = RequestMethod.PUT,value = "/product/addtowarehouse/{wHId}/{pId}/{quant}")
    public String addToWareHouse(@PathVariable int wHId, @PathVariable int pId, @PathVariable int quant){
        try {
            Product tempP=products.findById(pId).get();
            WareHouse tempW =wareHouses.findById(wHId).get();
            if (tempP!=null&&tempW!=null){
                WareHouseToProduct temp= new WareHouseToProduct(quant,wHId,pId);
                wPR.save(temp);
                return "the product "+tempP+" has been added to the warehouse "+tempW+" and the quntity is = "+quant;
            }
            return "please make sure of the IDs";
        }catch (Exception e){
            return "please make sure of the IDs";

        }
    }

    @RequestMapping("/product/warehouse/{pid}")
    public String getProductFromAWarehouse(@PathVariable int pid){

        return new Gson().toJson(wPR.findByProduct(pid));
    }

    //still need get by id
//still need softdeleted
//still need update
}
