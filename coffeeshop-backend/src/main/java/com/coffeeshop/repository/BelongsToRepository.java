package com.coffeeshop.repository;

import com.coffeeshop.model.BelongsTo;
import com.coffeeshop.model.Product;
import com.coffeeshop.model.Shop;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BelongsToRepository extends Neo4jRepository<Shop, Long> {

    @Query("MATCH (s:SHOP)<-[r:BELONGS_TO]-(p:PRODUCT) WHERE ID(s) = :#{#idShop} AND ID(p) = :#{#idProduct}  RETURN r")
    BelongsTo getPrice(Long idProduct, Long idShop);
}
