package com.coffeeshop.repository;

import com.coffeeshop.model.Product;
import com.coffeeshop.model.Shop;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ShopRepository extends Neo4jRepository<Shop, Long> {

    @Query("MATCH (s:SHOP)<-[r:BELONGS_TO]-(p:PRODUCT) MATCH (s:SHOP)<-[r2:RATED_BY]-(u:USER) RETURN s, collect(r), collect(p), collect(r2), collect(u)")
//    @Query("MATCH (s:shop)-[r:RATED_BY]->(u:user) UNWIND r AS rated RETURN s, collect(rated.rating), collect(u)")
    Collection<Shop> getAllShops();

    @Query("MATCH (s:SHOP)<-[r:BELONGS_TO]-(p:PRODUCT) MATCH (s:SHOP)<-[r2:RATED_BY]-(u:USER) WHERE ID(s) = $id RETURN s, collect(r), collect(p), collect(r2), collect(u)")
    Shop findShopById(Long id);

    @Query("MATCH (s:SHOP) WHERE s.name = $name RETURN s")
    Shop findShopByName(String name);

    @Query("CREATE (:SHOP {name: $shop.name, latitude: $shop.latitude, longitude: $shop.longitude})")
    void addShop(Shop shop);

    @Query("MATCH (s:SHOP) WHERE ID(s) = $id SET s.name = $newName RETURN s")
    Shop updateShop(Long id, String newName);

    @Query("MATCH (s:SHOP) WHERE ID(s) = $id DETACH DELETE s")
    void deleteShop(Long id);
}