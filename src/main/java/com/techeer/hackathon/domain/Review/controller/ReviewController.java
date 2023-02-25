package com.techeer.hackathon.domain.Review.controller;

import com.techeer.hackathon.domain.Restaurant.dto.Mapper.RestaurantMapper;
import com.techeer.hackathon.domain.Restaurant.dto.Request.RestaurantCreateRequestDto;
import com.techeer.hackathon.domain.Restaurant.dto.Respons.RestaurantResponseDto;
import com.techeer.hackathon.domain.Restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.Restaurant.service.RestaurantService;
import com.techeer.hackathon.domain.Review.dto.Mapper.ReviewMapper;
import com.techeer.hackathon.domain.Review.dto.Request.ReviewCreateRequestDto;
import com.techeer.hackathon.domain.Review.dto.Response.ReviewResponseDto;
import com.techeer.hackathon.domain.Review.entity.Review;
import com.techeer.hackathon.domain.Review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewService RESTAURANT_SERVICE;
    private final ReviewMapper RESTAURANT_MAPPER;

    @PostMapping
    public ResponseEntity<ReviewResponseDto> createRestaurant(@RequestBody ReviewCreateRequestDto reviewCreateRequestDto) {
        Review insertReview = RESTAURANT_SERVICE.insertReview(reviewCreateRequestDto);
        return new ResponseEntity(RESTAURANT_MAPPER.getDataFromEntity(insertReview), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant (@PathVariable Long id) {
        RESTAURANT_SERVICE.deleteRestaurant(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> findRestaurantId (@PathVariable Long id) {
        return ResponseEntity.ok(RESTAURANT_SERVICE.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Review> updateRestaurant(@RequestBody ReviewCreateRequestDto reviewCreateRequestDto, @PathVariable Long id) {
        return ResponseEntity.ok(RESTAURANT_SERVICE.updateRestaurant(id, reviewCreateRequestDto));
    }

    @GetMapping
    public List<Review> findAll() {
        return RESTAURANT_SERVICE.findAllRestaurant();
    }
}
