package com.coffeeshop.service;

import com.coffeeshop.model.Shop;
import com.coffeeshop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ShopService {

    @Autowired
    ShopRepository shopRepository;

    public Collection<Shop> getAllShops() {
        return shopRepository.getAllShops();
    }

    public Shop findShopById(Long id){
        return shopRepository.findShopById(id);
    }

    public void addShop(Shop shop) {
        shopRepository.addShop(shop);
    }

    public Shop updateShop(Long id, String newName){
        return shopRepository.updateShop(id, newName);
    }

    public Shop findShopByName(String name) {
        return shopRepository.findShopByName(name);
    }

    public void deleteShop(Long id) {
        shopRepository.deleteShop(id);
    }
}
