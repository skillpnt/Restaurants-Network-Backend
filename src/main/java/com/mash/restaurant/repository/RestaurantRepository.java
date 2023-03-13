package com.mash.restaurant.repository;

import com.mash.restaurant.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

}
