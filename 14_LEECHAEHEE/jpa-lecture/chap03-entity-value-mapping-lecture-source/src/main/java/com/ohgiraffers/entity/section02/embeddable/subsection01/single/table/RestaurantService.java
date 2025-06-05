package com.ohgiraffers.entity.section02.embeddable.subsection01.single.table;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional
    public void insertRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = Restaurant.builder()
                .id(restaurantDTO.getId())
                .name(restaurantDTO.getName())
                .since(restaurantDTO.getSince())
                .grade(restaurantDTO.getGrade())
                .address(restaurantDTO.getAddress())
                .build();

        restaurantRepository.save(restaurant);
    }
}
