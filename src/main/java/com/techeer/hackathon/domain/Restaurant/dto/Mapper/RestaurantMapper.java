package com.techeer.hackathon.domain.Restaurant.dto.Mapper;

import com.techeer.hackathon.domain.Restaurant.dto.Request.RestaurantCreateRequestDto;
import com.techeer.hackathon.domain.Restaurant.dto.Respons.RestaurantResponseDto;
import com.techeer.hackathon.domain.Restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantMapper {

    public Restaurant saveDataToEntity(RestaurantCreateRequestDto restaurantCreateRequestDto) {
        return Restaurant.builder()
                .category(restaurantCreateRequestDto.getCategory())
                .restaurantName(restaurantCreateRequestDto.getRestaurantName())
                .build();
    }

    public RestaurantResponseDto getDataFromEntity(Restaurant restaurant) {
        return RestaurantResponseDto.builder()
                .id(restaurant.getId())
                .category(restaurant.getCategory())
                .restaurantName(restaurant.getRestaurantName())
                .build();
    }
}
