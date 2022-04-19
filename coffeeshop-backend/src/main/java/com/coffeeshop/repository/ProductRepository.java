package com.coffeeshop.repository;

import com.coffeeshop.model.Product;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductRepository extends Neo4jRepository<Product, Long> {

    @Query("MATCH (p:PRODUCT)-[r:BELONGS_TO]->(s:SHOP) RETURN p, collect(r), collect(s)")
    Collection<Product> getAllProducts();

//    @Query("MATCH (p:PRODUCT)-[r:BELONGS_TO]->(s:SHOP) WHERE ID(p) = $id RETURN p, collect(r), collect(s)")
//    Product findProductById(Long id);

//    @Query("CREATE (p:PRODUCT {name: $product.name, size: $product.size}) RETURN p")
//    void addProduct(Product product);

    @Query("MATCH (p:PRODUCT) WHERE p.name = $name return p")
    Product findProductByName(String name);

    @Query("MATCH (p:PRODUCT) WHERE ID(p) = $id SET p.size = $newSize RETURN p")
    Product updateProductSize(Long id, String newSize);

    @Query("MATCH (p:PRODUCT) WHERE ID(p) = :#{#id} DETACH DELETE p")
    void deleteProduct(Long id);
}
