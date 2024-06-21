package com.example.food_recipe_project;

import java.io.Serializable;

public class Product_Model implements Serializable {
    String description,name,type,uri,offer;
    int rate;

    public Product_Model() {
    }

    public Product_Model(String description, String name, String type, String uri, String offer, int rate) {
        this.description = description;
        this.name = name;
        this.type = type;
        this.uri = uri;
        this.offer = offer;
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
