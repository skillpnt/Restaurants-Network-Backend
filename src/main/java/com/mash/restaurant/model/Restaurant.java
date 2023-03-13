package com.mash.restaurant.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @Column(name = "id")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private int id;

    @Column
    private String address;

    @ManyToMany
    @JoinTable(
            name = "restaurant_menu",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "food_item_id"))
    Set<FoodItem> foodItemSet;

    public Restaurant(String address) {
        this.address = address;
    }

    public Restaurant() {

    }

    public Set<FoodItem> getFoodItemSet() {
        return foodItemSet;
    }

    public void setFoodItemSet(Set<FoodItem> foodItemSet) {
        this.foodItemSet = foodItemSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String name) {
        this.address = name;
    }
}
