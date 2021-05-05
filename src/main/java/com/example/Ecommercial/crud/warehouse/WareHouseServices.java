package com.example.Ecommercial.crud.warehouse;


import com.example.Ecommercial.crud.product.Product;
import com.example.Ecommercial.crud.product.ProductRepo;
import com.example.Ecommercial.crud.warehouse.WtoP.WareHouseToProduct;
import com.example.Ecommercial.crud.warehouse.WtoP.WareHouseToProuductRepo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WareHouseServices {

    @Autowired
    WareHouseRepo warehouses;

    @Autowired
    ProductRepo products;

    @Autowired
    WareHouseToProuductRepo wPR;


    @RequestMapping(method = RequestMethod.POST, value = "/warehouse")
    public String addWareHouse(@RequestBody WareHouse wareHouse){
        try{
            warehouses.save(wareHouse);
            return new  Gson().toJson(wareHouse)+" has been added";
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



    @RequestMapping(method = RequestMethod.PUT,value = "/warehouse/addtowarehouse/{wHId}/{pId}/{quant}")
    public String addToWareHouse(@PathVariable int wHId, @PathVariable int pId, @PathVariable int quant){
        try {
            Product tempP=products.findById(pId).get();
            WareHouse tempW =warehouses.findById(wHId).get();
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

    @RequestMapping("/warehouse/products/{wid}")
    public String getTheInSideTheWarehouse(@PathVariable int wid){
        return new Gson().toJson(wPR.findBywareHouse(wid));
    }

    @RequestMapping("/warehouse/{wid}")
    public String getWarehousById(@PathVariable int wid){
        return new Gson().toJson(warehouses.findById(wid));
    }

    //still need get by id
    //still need softdeleted
    @RequestMapping(method = RequestMethod.DELETE,value = "/warehouse/{wid}")
    public String setWarehousDeleted(@PathVariable int wid){
        WareHouse wearhose = warehouses.findById(wid).get();
        wearhose.setDeleted(true);
        warehouses.save(wearhose);

        return new Gson().toJson(warehouses.findById(wid) + "Soft Deleted");
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/warehouse/{wid}")
    public String setUpdate(@PathVariable int wid ,@RequestBody WareHouse temp){
        WareHouse wear = warehouses.findById(wid).get();
if(temp.getAddress()!=null && !temp.getAddress().isEmpty())
{
    wear.setAddress(temp.getAddress());

}
       if(temp.getCity()!=null && !temp.getCity().isEmpty() )
           wear.setCity(temp.getCity());
       if(temp.getPhoneNO()!=null && !temp.getPhoneNO().isEmpty())
           wear.setPhoneNO(temp.getPhoneNO());
       if(temp.isDeleted()==true)
           wear.setDeleted(true);
       if(temp.getCapacity()!=0)
           wear.setCapacity(temp.getCapacity());
     warehouses.save(wear);
        return new Gson().toJson(wear) +"";

    }
    //still need update
}
