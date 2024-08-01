package com.example.TravelWeb.dto.wish;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class WishResponse {

    private Long wishId;
    private Long userId;
    private Long productId;
    private String wishName;
    private int wishPrice;
    private String product_detail_firstday; //여행시작날짜
    private String src;

    @Builder
    public WishResponse(Long wishId, Long userId, Long productId, String wishName, int wishPrice, String product_detail_firstday, String src) {
        this.wishId = wishId;
        this.userId = userId;
        this.productId = productId;
        this.wishName = wishName;
        this.wishPrice = wishPrice;
        this.product_detail_firstday = product_detail_firstday;
        this.src = src;
    }
}


