package com.example.Ecommercial.crud.warehouse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WareHouseServices {

    @Autowired
    WareHouseRepo warehouses;

    @RequestMapping(method = RequestMethod.POST, value = "/warehouse")
    public String addWareHouse(@RequestBody WareHouse wareHouse){
        try{
            warehouses.save(wareHouse);
            return wareHouse+" has been added";
        }catch (Exception e){
            return "somthing went wrong";
        }
    }

    @RequestMapping("/warehouse")
    public String getWareHouses(){
        try {
            List <WareHouse> rez= new ArrayList<>();
            List <WareHouse> all= (List<WareHouse>) warehouses.findAll();
            for (WareHouse w:all){
                if (!w.isDeleted)
                    rez.add(w);
            }
            Gson g= new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

            return g.toJson(rez);
        }catch (Exception e){
            return "please try agin later";
        }
    }
    //still need get by id
    //still need softdeleted
    //still need update
}
