package com.theBeautiful.cassandra.model;

import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.google.common.collect.Maps;
import com.theBeautiful.model.Price;
import com.theBeautiful.model.Product;

import java.util.Map;
import java.util.Set;

@Table(keyspace = "bundles", name = "Product")
public class ProductEntity implements DBEntityInterface<Product>{
    @PartitionKey
    private String id;

    private String name;

    private String description;

    private String category;

    private Set<String> sizes;

    private Set<String> textures;

    private Set<String> colors;

    private Boolean onSale;

    private Map<String, PriceType> prices;

    private Set<String> picturesLocations;

    private Map<String, String> reviews;

    public ProductEntity() {
    }

    public ProductEntity(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.category = product.getCategory();
        this.sizes = product.getSizes();
        this.textures = product.getTextures();
        this.colors = product.getColors();
        this.onSale = product.getOnSale();
        if (product.getPrices() != null) {
            if (this.getPrices() == null) {
                this.prices = Maps.newHashMap();
            }
            for (Map.Entry<String, Price> entry : product.getPrices().entrySet()) {
                this.prices.put(entry.getKey(), new PriceType(entry.getValue()));
            }
        }
        this.picturesLocations = product.getPicturesLocations();
        this.reviews = product.getReviews();
    }

    @Override
    public Product generate() {
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setDescription(this.description);
        product.setCategory(this.category);
        product.setSizes(this.sizes);
        product.setTextures(this.textures);
        product.setColors(this.colors);
        product.setOnSale(this.onSale);
        if (this.prices != null) {
            Map<String, Price> priceMap = Maps.newHashMap();
            for (Map.Entry<String, PriceType> entry : this.prices.entrySet()) {
                priceMap.put(entry.getKey(), entry.getValue().generate());
            }
        }
        product.setPicturesLocations(this.picturesLocations);
        product.setReviews(this.reviews);

        return product;
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

    public Set<String> getSizes() {
        return sizes;
    }

    public void setSizes(Set<String> sizes) {
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

    public Map<String, PriceType> getPrices() {
        return prices;
    }

    public void setPrices(Map<String, PriceType> prices) {
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
