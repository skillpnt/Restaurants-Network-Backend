package com.mash.restaurant.controller;

import com.mash.restaurant.model.Restaurant;
import com.mash.restaurant.model.RestaurantMenu;
import com.mash.restaurant.repository.RestaurantMenuRepository;
import com.mash.restaurant.repository.RestaurantRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMenuRepository menuRepository;

    public RestaurantController(RestaurantRepository restaurantRepository, RestaurantMenuRepository menuRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
    }

    @GetMapping("/restaurants")
    public @ResponseBody Iterable<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/restaurants/{restaurantId}")
    public @ResponseBody Iterable<RestaurantMenu> getRestaurantMenu(@PathVariable int restaurantId) {return menuRepository.findByRestaurantId(restaurantId);}

    @GetMapping("/restaurants/{restaurantId}/quantity/{foodItemId}")
    public @ResponseBody Iterable<RestaurantMenu> getItemStock(@PathVariable int restaurantId, @PathVariable int foodItemId) {return menuRepository.findQuantityByRestaurantIdAndFoodItemId(restaurantId, foodItemId);}

    @PutMapping("/restaurants/{restaurantId}/sold/{foodItemId}/{count}")
    public void updateSoldItem(@PathVariable int restaurantId, @PathVariable int foodItemId, @PathVariable int count) {menuRepository.updateSoldId(restaurantId, foodItemId, count);}

    @PutMapping("/restaurants/{restaurantId}/arrived/{foodItemId}/{count}")
    public void updateArrivedItem(@PathVariable int restaurantId, @PathVariable int foodItemId, @PathVariable int count) {menuRepository.updateArrivedId(restaurantId, foodItemId, count);}
}
