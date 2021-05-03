package com.example.Ecommercial.crud.warehouse.WtoP;

import com.example.Ecommercial.crud.product.Product;
import com.example.Ecommercial.crud.product.ProductRepo;
import com.example.Ecommercial.crud.warehouse.WareHouse;
import com.example.Ecommercial.crud.warehouse.WareHouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WareHouseToProductService {


    @Autowired
    ProductRepo products;

    @Autowired
    WareHouseRepo wareHouses;

    @Autowired
    WareHouseToProuductRepo wPR;

}
