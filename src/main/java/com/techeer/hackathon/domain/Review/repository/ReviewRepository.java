package com.techeer.hackathon.domain.Review.repository;

import com.techeer.hackathon.domain.Review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
