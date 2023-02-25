package com.techeer.hackathon.domain.Review.service;

import com.techeer.hackathon.domain.Restaurant.Repository.RestaurantRepository;
import com.techeer.hackathon.domain.Restaurant.dto.Mapper.RestaurantMapper;
import com.techeer.hackathon.domain.Restaurant.dto.Request.RestaurantCreateRequestDto;
import com.techeer.hackathon.domain.Restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.Review.dto.Mapper.ReviewMapper;
import com.techeer.hackathon.domain.Review.dto.Request.ReviewCreateRequestDto;
import com.techeer.hackathon.domain.Review.entity.Review;
import com.techeer.hackathon.domain.Review.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewService {

    private final ReviewMapper MAPPER;

    private final ReviewRepository REPOSITORY;

    @Transactional
    public Review insertReview(ReviewCreateRequestDto reviewCreateRequestDto) {
        return REPOSITORY.save(MAPPER.saveDataToEntity(reviewCreateRequestDto));
    }

    @Transactional
    public List<Review> findAllReview() {
        return REPOSITORY.findAll(); //전체 찾기
    }

    @Transactional
    public void deleteReview(Long id) {
        REPOSITORY.deleteById(id); //삭제
    }

    @Transactional
    public Review findById(Long id) {
        Optional<Review> review = REPOSITORY.findById(id);
        if (review.isPresent()) {
            return review.get();
        }
        throw new EntityNotFoundException(
                "ID를 찾지 못했습니다"
        );
    }

    @Transactional
    public Review updateReview(Long id, ReviewCreateRequestDto reviewCreateRequestDto) {
        Optional<Review> optionalReview = REPOSITORY.findById(id);
        if (!optionalReview.isPresent()) {
            throw new EntityNotFoundException(
                    "ID가 없습니다"
            );
        }
        Review review = optionalReview.get();
        review.setDetail(review.getDetail());
        review.setIndex(review.getIndex());
        return REPOSITORY.save(review);
    }

//    @Transactional
//        public List<Review> search(String keyword) {
//        List<Review> reviewList = REPOSITORY.findByTitleContaining(keyword);
//        return reviewList;
//    }

}
