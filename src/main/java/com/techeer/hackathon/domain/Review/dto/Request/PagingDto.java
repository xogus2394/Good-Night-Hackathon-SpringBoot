package com.techeer.hackathon.domain.Review.dto.Request;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class PagingDto {

    private String detail;

    private String index;

    private Long reviewId;


    public PagingDto(Long reviewId, String index, String detail) {
        this.reviewId = reviewId;
        this.index = index;
        this.detail = detail;
    }
}
