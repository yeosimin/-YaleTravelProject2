package com.example.TravelWeb.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProductDTO {

    private Long productId;
    private String productName;
    private String productDescription;
    private String productImageUrl;
    private LocalDateTime productCreatedAt;
    private LocalDateTime productUpdatedAt;
    private Boolean productIsInternational;
    private Boolean productFlag;
    private Integer productPlaceOfDeparture; // 추가된 필드
    private Integer productViews;

    // 추가된 필드
    private List<ProductDetailDTO> productDetails;

    // Getters and Setters
}
