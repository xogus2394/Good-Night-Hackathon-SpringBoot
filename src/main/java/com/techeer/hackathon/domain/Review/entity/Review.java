package com.techeer.hackathon.domain.Review.entity;

import com.techeer.hackathon.domain.Restaurant.dto.Request.RestaurantUpdateRequestDto;
import com.techeer.hackathon.domain.Restaurant.entity.Restaurant;
import com.techeer.hackathon.global.common.Timestamps;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Getter
@Setter
@Service
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "review")
@SQLDelete(sql = "UPDATE review SET deleted_at = CURRENT_TIMESTAMP where REVIEW_ID = ?")
@Where(clause = "deleted=false")
public class Review extends Timestamps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Review_id")
    private Long reviewId;

    @Column(name = "Review_index")
    private String index;

    @Column(name = "Review_detail")
    private String detail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


    private boolean deleted = Boolean.FALSE;


}
