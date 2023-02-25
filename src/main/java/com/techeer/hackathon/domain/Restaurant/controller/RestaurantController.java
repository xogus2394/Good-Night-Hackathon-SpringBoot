package com.techeer.hackathon.domain.Restaurant.controller;

import com.techeer.hackathon.domain.Restaurant.dto.Mapper.RestaurantMapper;
import com.techeer.hackathon.domain.Restaurant.dto.Request.RestaurantCreateRequestDto;
import com.techeer.hackathon.domain.Restaurant.dto.Request.RestaurantUpdateRequestDto;
import com.techeer.hackathon.domain.Restaurant.dto.Respons.RestaurantResponseDto;
import com.techeer.hackathon.domain.Restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.Restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantService RESTAURANT_SERVICE;
    private final RestaurantMapper RESTAURANT_MAPPER;

    @PostMapping
    public ResponseEntity<RestaurantResponseDto> createRestaurant(@RequestBody RestaurantCreateRequestDto restaurantCreateRequestDto) {
        Restaurant insertRestaurant = RESTAURANT_SERVICE.insertRestaurant(restaurantCreateRequestDto);
        return new ResponseEntity(RESTAURANT_MAPPER.getDataFromEntity(insertRestaurant), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant (@PathVariable Long id) {
        RESTAURANT_SERVICE.deleteRestaurant(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findRestaurantId (@PathVariable Long id) {
        return ResponseEntity.ok(RESTAURANT_SERVICE.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantResponseDto> updateRestaurant(@RequestBody RestaurantUpdateRequestDto restaurantUpdateRequestDto) {
        Restaurant updateRestaurantResult = RESTAURANT_SERVICE.updateRestaurant(restaurantUpdateRequestDto);
        return new ResponseEntity<>(RESTAURANT_MAPPER.getDataFromEntity(updateRestaurantResult), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Restaurant> findAll() {
        return RESTAURANT_SERVICE.findAllRestaurant();
    }
}
