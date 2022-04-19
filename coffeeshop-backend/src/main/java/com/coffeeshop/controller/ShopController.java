package com.coffeeshop.controller;

import com.coffeeshop.model.Shop;
import com.coffeeshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @GetMapping
    public Collection<Shop> getAllShops(){
        return shopService.getAllShops();
    }

    @GetMapping("/{id}")
    public Shop findShopById(@PathVariable Long id){
        return shopService.findShopById(id);
    }

    @PostMapping()
    public String addShop(@RequestBody Shop shop){
        shopService.addShop(shop);
        return "Shop added";
    }

    @GetMapping("/{name}")
    Shop findShopByName(@PathVariable String name){
        return shopService.findShopByName(name);
    }

    @PutMapping("/{id}")
    public Shop updateShop(@PathVariable Long id, @RequestBody String newName){
        return shopService.updateShop(id, newName);
    }

    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable Long id){
        shopService.deleteShop(id);
    }

}
