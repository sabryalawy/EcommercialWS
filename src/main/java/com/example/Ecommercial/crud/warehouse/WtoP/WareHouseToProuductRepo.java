package com.example.Ecommercial.crud.warehouse.WtoP;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface WareHouseToProuductRepo extends CrudRepository<WareHouseToProduct,Integer> {
    public List<WareHouseToProduct> findByProduct(int product);
    public List<WareHouseToProduct> findBywareHouse(int wareHouse);
}
