package com.coffeeshop.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

@RelationshipEntity(type = "BELONGS_TO")
public class BelongsTo {

    @Id
    @GeneratedValue
    private Long id;

    private float price;

    @StartNode
    private Product product;

    @EndNode
    private Shop shop;


}