package com.coffeeshop.controller;

import com.coffeeshop.model.BelongsTo;
import com.coffeeshop.service.BelongsToService;
import com.coffeeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/neo4j/product/price/{idProduct}/{idShop}")
public class BelongsToController {

    @Autowired
    BelongsToService belongsToService;

    @GetMapping
    public BelongsTo getPrice(@PathVariable Long idProduct, @PathVariable Long idShop){
        return belongsToService.getPrice(idProduct, idShop);
    }

}
