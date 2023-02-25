package com.techeer.hackathon.domain.Review.dto.Request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewCreateRequestDto {

    private String index;

    private String detail;
}
