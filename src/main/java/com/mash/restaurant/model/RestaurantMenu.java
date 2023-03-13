package com.mash.restaurant.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "restaurant_menu")
public class RestaurantMenu {

    @Id
    @Column
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private int id;

    @Column(name = "restaurant_id")
    private int restaurantId;

    @Column(name = "food_item_id")
    private int foodItemId;

    @Column
    private int quantityInStock;

    public RestaurantMenu(int restaurantId, int foodItemId, int quantityInStock) {
        this.restaurantId = restaurantId;
        this.foodItemId = foodItemId;
        this.quantityInStock = quantityInStock;
    }

    public RestaurantMenu() {
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
