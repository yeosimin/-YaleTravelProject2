package com.example.TravelWeb.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductDetailDTO {
    private Long productDetailId;
    private Long productId;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime productDetailFirstDay;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime productDetailLastDay;

    private int productDetailTotalCount;
    private int productAdultPrice;
    private int productTeenagerPrice;
    private int productInfantPrice;
    private int productDetailAirplane;  // 필드명 수정

    // Getters and Setters
}
