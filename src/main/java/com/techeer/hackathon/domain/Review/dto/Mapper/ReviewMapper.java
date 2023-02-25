package com.techeer.hackathon.domain.Review.dto.Mapper;

import com.techeer.hackathon.domain.Review.dto.Request.ReviewCreateRequestDto;
import com.techeer.hackathon.domain.Review.dto.Response.ReviewResponseDto;
import com.techeer.hackathon.domain.Review.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewMapper {

    public Review saveDataToEntity(ReviewCreateRequestDto reviewCreateRequestDto) {
        return Review.builder()
                .detail(reviewCreateRequestDto.getDetail())
                .index(reviewCreateRequestDto.getIndex())
                .build();
    }

    public ReviewResponseDto getDataFromEntity(Review review) {
        return ReviewResponseDto.builder()
                .reviewId(review.getReviewId())
                .index(review.getIndex())
                .index(review.getDetail())
                .build();
    }

}
