package com.example.TravelWeb.dto.wish;


import lombok.Builder;
import lombok.Data;

@Data
public class WishRemoveRequest {

    private Long wishId;

    @Builder
    public WishRemoveRequest(Long wishId) {
        this.wishId = wishId;
    }
}
