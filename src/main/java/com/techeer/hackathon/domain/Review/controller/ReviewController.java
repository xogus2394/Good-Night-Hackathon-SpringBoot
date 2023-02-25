package com.techeer.hackathon.domain.Review.controller;

import com.techeer.hackathon.domain.Restaurant.dto.Mapper.RestaurantMapper;
import com.techeer.hackathon.domain.Restaurant.dto.Request.RestaurantCreateRequestDto;
import com.techeer.hackathon.domain.Restaurant.dto.Respons.RestaurantResponseDto;
import com.techeer.hackathon.domain.Restaurant.entity.Restaurant;
import com.techeer.hackathon.domain.Restaurant.service.RestaurantService;
import com.techeer.hackathon.domain.Review.dto.Mapper.ReviewMapper;
import com.techeer.hackathon.domain.Review.dto.Request.PagingDto;
import com.techeer.hackathon.domain.Review.dto.Request.ReviewCreateRequestDto;
import com.techeer.hackathon.domain.Review.dto.Response.ReviewResponseDto;
import com.techeer.hackathon.domain.Review.entity.Review;
import com.techeer.hackathon.domain.Review.repository.ReviewRepository;
import com.techeer.hackathon.domain.Review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewService REVIEW_SERVICE;
    private final ReviewMapper REVIEW_MAPPER;

    private final ReviewRepository REVIEW_REPOSITORY;

    @PostMapping
    public ResponseEntity<ReviewResponseDto> createRestaurant(@RequestBody ReviewCreateRequestDto reviewCreateRequestDto) {
        Review insertReview = REVIEW_SERVICE.insertReview(reviewCreateRequestDto);
        return new ResponseEntity(REVIEW_MAPPER.getDataFromEntity(insertReview), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        REVIEW_SERVICE.deleteReview(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> findReviewId(@PathVariable Long id) {
        return ResponseEntity.ok(REVIEW_SERVICE.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@RequestBody ReviewCreateRequestDto reviewCreateRequestDto, @PathVariable Long id) {
        return ResponseEntity.ok(REVIEW_SERVICE.updateReview(id, reviewCreateRequestDto));
    }

    @GetMapping
    public List<Review> findAll() {
        return REVIEW_SERVICE.findAllReview();
    }

//    @GetMapping("/review/search")
//        public String search(String keyword, Model model) {
//        List<Review> searchList = REVIEW_SERVICE.search(keyword);
//
//        model.addAttribute("searchList", searchList);
//
//        return "posts-search";
//    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/page")
    public Page<PagingDto> paging(@PageableDefault(size = 5, sort = "reviewId") Pageable pageRequest) {

        Page<Review> postList = REVIEW_REPOSITORY.findAll(pageRequest);

        Page<PagingDto> pagingList = postList.map(
                review -> new PagingDto(
                        review.getReviewId(), review.getIndex(),
                        review.getDetail()
                ));

        return pagingList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/search")
    public Page<PagingDto> searchPaging(
            @RequestParam String index,
            @RequestParam String detail,
            @PageableDefault(size = 5, sort = "reviewId") Pageable pageRequest) {

        Page<Review> reviewList = REVIEW_REPOSITORY.findAllSearch(index, detail, pageRequest);

        Page<PagingDto> pagingList = reviewList.map(
                review -> new PagingDto(
                        review.getReviewId(), review.getIndex(),
                        review.getDetail()
                ));

        return pagingList;
    }

}
