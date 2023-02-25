package com.techeer.hackathon.domain.Review.entity;

import com.techeer.hackathon.domain.Restaurant.dto.Request.RestaurantUpdateRequestDto;
import com.techeer.hackathon.domain.Restaurant.entity.Restaurant;
import com.techeer.hackathon.global.common.Timestamps;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Getter
@Setter
@Service
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Restaurant")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Review_id")
    private Long reviewId;

    @Column(name = "Review_index")
    private String index;

    @Column(name = "Review_detail")
    private String detail;

}
