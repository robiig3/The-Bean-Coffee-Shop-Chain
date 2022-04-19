package com.coffeeshop.service;

import com.coffeeshop.model.BelongsTo;
import com.coffeeshop.model.Product;
import com.coffeeshop.repository.BelongsToRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BelongsToService {

    @Autowired
    BelongsToRepository belongsToRepository;

    public BelongsTo getPrice(Long idProduct, Long idShop){
        return belongsToRepository.getPrice(idProduct, idShop);
    }

}
