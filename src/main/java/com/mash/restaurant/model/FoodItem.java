package com.mash.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
@Table(name = "food_item")
public class FoodItem {

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private int id;

    @Column
    private String name;

    @Column
    private double price;

    @JsonIgnore
    @ManyToMany(mappedBy = "foodItemSet")
    Set<Restaurant> restaurantSet;


    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public FoodItem() {

    }


    public Set<Restaurant> getRestaurantSet() {
        return restaurantSet;
    }

    public void setRestaurantSet(Set<Restaurant> restaurantSet) {
        this.restaurantSet = restaurantSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
