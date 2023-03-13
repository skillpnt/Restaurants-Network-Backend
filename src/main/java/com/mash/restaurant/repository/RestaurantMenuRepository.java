package com.mash.restaurant.repository;

import com.mash.restaurant.model.RestaurantMenu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RestaurantMenuRepository extends CrudRepository<RestaurantMenu, Integer> {

    Iterable<RestaurantMenu> findByRestaurantId(int restaurantId);

    Iterable<RestaurantMenu> findQuantityByRestaurantIdAndFoodItemId(int restaurantId, int foodItemId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE RestaurantMenu SET quantityInStock = (quantityInStock - :count) WHERE restaurantId = :restaurantId and foodItemId = :foodItemId")
    void updateSoldId(int restaurantId, int foodItemId, int count);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE RestaurantMenu SET quantityInStock = (quantityInStock + :count) WHERE restaurantId = :restaurantId and foodItemId = :foodItemId")
    void updateArrivedId(int restaurantId, int foodItemId, int count);


}
