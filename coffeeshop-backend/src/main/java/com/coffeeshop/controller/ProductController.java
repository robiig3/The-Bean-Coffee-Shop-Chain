package com.coffeeshop.controller;

import com.coffeeshop.model.Product;
import com.coffeeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public Collection<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id){
        Optional<Product> product = productService.findProductById(id);

        return product.orElse(null);
    }

    @PostMapping()
    public String addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return "Product added";
    }

    @GetMapping("/{name}")
    Product findProductByName(@PathVariable String name){
        return productService.findProductByName(name);
    }

    @PutMapping("/{id}")
    public Product updateProductSize(@PathVariable Long id, @RequestBody String newSize){
        return productService.updateProductSize(id, newSize);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        Optional<Product> p = productService.findProductById(id);

        if(p.isPresent()){
            productService.deleteProduct(p.get());
            return "Product deleted";
        }else return "Product do not exists";

    }

}
