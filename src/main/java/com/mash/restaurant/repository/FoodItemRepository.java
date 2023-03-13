package com.mash.restaurant.repository;

import com.mash.restaurant.model.FoodItem;
import org.springframework.data.repository.CrudRepository;

public interface FoodItemRepository extends CrudRepository<FoodItem, Integer> {

}
