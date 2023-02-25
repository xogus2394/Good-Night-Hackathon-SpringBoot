package com.techeer.hackathon.domain.Restaurant.entity;


import com.techeer.hackathon.domain.Restaurant.dto.Request.RestaurantUpdateRequestDto;
import com.techeer.hackathon.global.common.Timestamps;
import lombok.*;
import org.hibernate.annotations.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor //
@Builder
@Entity
@SQLDelete(sql = "UPDATE restaurant SET deleted_at = CURRENT_TIMESTAMP where id = ?")
@Where(clause = "deleted=false")
@Table(name = "restaurant")
//@FilterDef(name = "deletedEntityFilter", parameters = @ParamDef(name = "deleted", type = "boolean"))
//@Filter(name = "deletedEntityFilter", condition = "deleted = :deleted")
public class Restaurant extends Timestamps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // 아이디 값

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "category")
    private String category;

    private boolean deleted = Boolean.FALSE;

    public Restaurant updateRestaurant(RestaurantUpdateRequestDto restaurantUpdateRequestDto) {

        this.category = restaurantUpdateRequestDto.getCategory();
        this.restaurantName = restaurantUpdateRequestDto.getRestaurantName();
        return this;
    }

}
