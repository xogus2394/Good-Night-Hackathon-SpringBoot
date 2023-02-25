package com.techeer.hackathon.domain.Restaurant.dto.Request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RestaurantUpdateRequestDto {

    private Long id;

    private String category;

    private String restaurantName;

}
