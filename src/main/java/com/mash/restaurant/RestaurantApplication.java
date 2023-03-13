package com.mash.restaurant;

import com.mash.restaurant.model.FoodItem;
import com.mash.restaurant.model.Restaurant;
import com.mash.restaurant.model.RestaurantMenu;
import com.mash.restaurant.repository.FoodItemRepository;
import com.mash.restaurant.repository.RestaurantMenuRepository;
import com.mash.restaurant.repository.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadFoodData(FoodItemRepository repository) {
		return (args -> {
			repository.save(new FoodItem("Apple", 50));
			repository.save(new FoodItem("Fried Chicken", 500));
			repository.save(new FoodItem("Mashed Potatoes", 100));
			repository.save(new FoodItem("Pizza", 350));
			repository.save(new FoodItem("Caesar Salad", 150));
		});
	}

	@Bean
	public CommandLineRunner loadRestaurants(RestaurantRepository repository) {
		return (args -> {
			repository.save(new Restaurant("Learning Campus 1"));
			repository.save(new Restaurant("Learning Campus 2"));
			repository.save(new Restaurant("Learning Campus 3"));
			repository.save(new Restaurant("Learning Campus 4"));
			repository.save(new Restaurant("Learning Campus 5"));
			repository.save(new Restaurant("Learning Campus 6"));
			repository.save(new Restaurant("Learning Campus 7"));
			repository.save(new Restaurant("Learning Campus 8"));
		});
	}

	@Bean
	public CommandLineRunner loadMenus(RestaurantMenuRepository menuRepository) {
		return (args -> {
			menuRepository.save(new RestaurantMenu(1, 1, 25));
			menuRepository.save(new RestaurantMenu(1, 4, 11));
			menuRepository.save(new RestaurantMenu(1, 5, 10));
			menuRepository.save(new RestaurantMenu(2, 3, 7));
			menuRepository.save(new RestaurantMenu(2, 4, 5));
			menuRepository.save(new RestaurantMenu(2, 5, 14));
			menuRepository.save(new RestaurantMenu(3, 1, 20));
		});
	}
}
