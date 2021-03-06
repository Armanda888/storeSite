package com.theBeautiful.model;

import java.util.Map;
import java.util.Set;

public class Product {
    private String id;

    private String name;

    private String description;

    private String category;

    private Set<Integer> sizes;

    private Set<String> textures;

    private Set<String> colors;

    private Boolean onSale;

    private Map<String, Price> prices;

    private Set<String> picturesLocations;

    private Map<String, String> reviews;

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Integer> getSizes() {
        return sizes;
    }

    public void setSizes(Set<Integer> sizes) {
        this.sizes = sizes;
    }

    public Set<String> getTextures() {
        return textures;
    }

    public void setTextures(Set<String> textures) {
        this.textures = textures;
    }

    public Set<String> getColors() {
        return colors;
    }

    public void setColors(Set<String> colors) {
        this.colors = colors;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public Map<String, Price> getPrices() {
        return prices;
    }

    public void setPrices(Map<String, Price> prices) {
        this.prices = prices;
    }

    public Set<String> getPicturesLocations() {
        return picturesLocations;
    }

    public void setPicturesLocations(Set<String> picturesLocations) {
        this.picturesLocations = picturesLocations;
    }

    public Map<String, String> getReviews() {
        return reviews;
    }

    public void setReviews(Map<String, String> reviews) {
        this.reviews = reviews;
    }
}
