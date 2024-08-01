package com.example.TravelWeb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "product_table")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name", nullable = false, length = 255)
    private String productName;

    @Column(name = "product_description", columnDefinition = "TEXT")
    private String productDescription;

    @Column(name = "product_image_url", length = 255)
    private String productImageUrl;

    @Column(name = "product_created_at", nullable = false, updatable = false)
    private LocalDateTime productCreatedAt;

    @Column(name = "product_updated_at", nullable = false)
    private LocalDateTime productUpdatedAt;

    @Column(name = "product_is_international", nullable = false)
    private Boolean productIsInternational;

    @Column(name = "product_flag", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0 COMMENT '0은 판매상품, 1은 삭제상품'")
    private Boolean productFlag;

    @Column(name = "product_place_of_departure", nullable = false)
    private Integer productPlaceOfDeparture;

    @Column(name = "product_views", nullable = false, columnDefinition = "INT DEFAULT 0 COMMENT '조회수'")
    private Integer productViews = 0;  // 기본 값을 설정하여 null 방지

    @PrePersist
    protected void onCreate() {
        this.productCreatedAt = LocalDateTime.now();
        this.productUpdatedAt = LocalDateTime.now();
        if (this.productIsInternational == null) {
            this.productIsInternational = false; // 기본값 설정
        }
        if (this.productFlag == null) {
            this.productFlag = false; // 기본값 설정
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.productUpdatedAt = LocalDateTime.now();
    }
}
