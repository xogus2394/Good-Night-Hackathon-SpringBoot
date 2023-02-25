package com.techeer.hackathon.domain.Restaurant.service;

import com.techeer.hackathon.domain.Restaurant.Repository.RestaurantRepository;
import com.techeer.hackathon.domain.Restaurant.dto.Mapper.RestaurantMapper;
import com.techeer.hackathon.domain.Restaurant.dto.Request.RestaurantCreateRequestDto;
import com.techeer.hackathon.domain.Restaurant.dto.Request.RestaurantUpdateRequestDto;
import com.techeer.hackathon.domain.Restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantMapper MAPPER;

    private final RestaurantRepository REPOSITORY;

    private final EntityManager entityManager;

    private final int NULL_SIZE = 0;

    @Transactional
    public Restaurant insertRestaurant(RestaurantCreateRequestDto restaurantCreateRequestDto) {
        return REPOSITORY.save(MAPPER.saveDataToEntity(restaurantCreateRequestDto));
    }

    @Transactional
    public List<Restaurant> findAllRestaurant() {
        return REPOSITORY.findAll(); //전체 찾기
    }

    @Transactional
    public void deleteRestaurant(Long id) {
        REPOSITORY.deleteById(id); //삭제
    }

    @Transactional
    public Restaurant findById(Long id) {
        Optional<Restaurant> restaurant = REPOSITORY.findById(id);
        if (restaurant.isPresent()) {
            return restaurant.get();
        }
        throw new EntityNotFoundException(
                "ID를 찾지 못했습니다"
        );
    }

//    @Transactional
//    public Restaurant updateRestaurant(Long id, RestaurantCreateRequestDto restaurantCreateRequestDto) {
//        Optional<Restaurant> optionalRestaurant = REPOSITORY.findById(id);
//        if (!optionalRestaurant.isPresent()) {
//            throw new EntityNotFoundException(
//                    "ID가 없습니다"
//            );
//        }
//        Restaurant restaurant = optionalRestaurant.get();
//        restaurant.setCategory(restaurant.getCategory());
//        restaurant.setRestaurantName(restaurant.getRestaurantName());
//        return REPOSITORY.save(restaurant);

//}

    @Transactional
    public Restaurant updateRestaurant(RestaurantUpdateRequestDto restaurantUpdateRequestDto) {
            Restaurant restaurant = isRestaurantExisted(restaurantUpdateRequestDto.getId());
            return restaurant.updateRestaurant(restaurantUpdateRequestDto);
    }

    private Restaurant isRestaurantExisted(Long id) {
        Restaurant restaurant = REPOSITORY.findById(id).orElseThrow(() -> new NullPointerException());

        return restaurant;
    }
}
