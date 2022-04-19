package com.coffeeshop.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;

import java.util.List;

@Node("SHOP")
public class Shop {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double latitude;
    private double longitude;

    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
    private List<Product> products;

    @Relationship(type = "RATED_BY", direction = Relationship.Direction.INCOMING)
    private List<User> usersReviews;

    public Shop() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<User> getUsersReviews() {
        return usersReviews;
    }

    public void setUsersReviews(List<User> usersReviews) {
        this.usersReviews = usersReviews;
    }
}
