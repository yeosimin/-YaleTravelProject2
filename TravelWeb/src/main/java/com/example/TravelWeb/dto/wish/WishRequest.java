package com.example.TravelWeb.dto.wish;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
//클릭시 wish를 db에 저장하는 dto
@Data
public class WishRequest {

    private Long userId;
    private Long productId;
    private Long productDetailId;
    private ZonedDateTime wishDate;
    private String wishName;
    private int wishPrice;


    @Builder
    public WishRequest(Long userId, Long productId, Long productDetailId, ZonedDateTime wishDate, String wishName, int wishPrice) {
        this.userId = userId;
        this.productId = productId;
        this.productDetailId = productDetailId;
        this.wishDate = wishDate;
        this.wishName = wishName;
        this.wishPrice = wishPrice;
    }
}
