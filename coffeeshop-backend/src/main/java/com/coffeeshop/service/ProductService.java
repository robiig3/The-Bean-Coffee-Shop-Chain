package com.coffeeshop.service;

import com.coffeeshop.model.Product;
import com.coffeeshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Collection<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product findProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    public Product updateProductSize(Long id, String newSize) {
        return productRepository.updateProductSize(id, newSize);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
