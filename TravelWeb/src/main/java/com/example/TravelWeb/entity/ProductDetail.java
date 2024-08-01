package com.example.TravelWeb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "product_detail_table")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_detail_id")
    private Long productDetailId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_detail_firstday", nullable = false)
    private LocalDateTime productDetailFirstDay;

    @Column(name = "product_detail_lastday", nullable = false)
    private LocalDateTime productDetailLastDay;

    @Column(name = "product_detail_total_count", nullable = false)
    private int productDetailTotalCount;



    @Column(name = "product_adult_price", nullable = false)
    private int productAdultPrice;

    @Column(name = "product_teenager_price", nullable = false)
    private int productTeenagerPrice;

    @Column(name = "product_infant_price", nullable = false)
    private int productInfantPrice;

    @Column(name = "product_detail_airplane", nullable = false)
    private int productDetailAirplane;  // 필드명 수정



    @PrePersist
    protected void onCreate() {
        if (this.productDetailFirstDay == null) {
            this.productDetailFirstDay = LocalDateTime.now();
        }
        if (this.productDetailLastDay == null) {
            this.productDetailLastDay = LocalDateTime.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.productDetailLastDay = LocalDateTime.now();
    }
}
