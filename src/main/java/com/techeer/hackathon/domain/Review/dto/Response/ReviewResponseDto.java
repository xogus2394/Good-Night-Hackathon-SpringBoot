package com.techeer.hackathon.domain.Review.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ReviewResponseDto {

    private Long reviewId;

    private String index;

    private String detail;
}
