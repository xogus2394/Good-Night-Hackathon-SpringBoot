package com.techeer.hackathon.domain.Review.repository;

import com.techeer.hackathon.domain.Review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

//    List<Review> findByTitleContaining(String keyword);

    Page<Review> findAll(Pageable pageable);

    @Query(
            value = "SELECT p FROM Review p WHERE p.detail LIKE %:detail% OR p.index LIKE %:index%",
            countQuery = "SELECT COUNT(p.reviewId) FROM Review p WHERE p.detail LIKE %:detail% OR p.index LIKE %:index%"
    )
    Page<Review> findAllSearch(String detail, String index, Pageable pageable);
}
