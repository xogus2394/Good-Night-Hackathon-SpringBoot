package com.techeer.hackathon.domain.Restaurant.Repository;

import com.techeer.hackathon.domain.Restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
