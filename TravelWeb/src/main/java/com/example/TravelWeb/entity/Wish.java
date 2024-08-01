package com.example.TravelWeb.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;


@Setter
@Getter
@Entity
@Table(name = "wish_table")
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wish_id")
    private Long wishId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_detail_id")
    private Long productDetailId;

    @Column(name = "wish_date")
    private ZonedDateTime wishDate;//db에서 timestemp로 하기에 적합하다고 함

    @Column(name = "wish_name")
    private String wishName;

    @Column(name = "wish_price")
    private int wishPrice;


    //시간자동으로 넣기
    //@PrePersist: 엔티티가 데이터베이스에 저장되기 전에 호출되는 메서드
    // 엔티티가 데이터베이스에 저장되기 전에 wishDate 필드에 현재 시간을 자동으로 설정하는 방법
    @PrePersist
    public void onCreate() {
        this.wishDate = ZonedDateTime.now();
    }


    @Builder
    public Wish(Long wishId, Long userId, Long productId, Long productDetailId, ZonedDateTime wishDate, String wishName, int wishPrice) {
        this.wishId = wishId;
        this.userId = userId;
        this.productId = productId;
        this.productDetailId = productDetailId;
        this.wishDate = wishDate;
        this.wishName = wishName;
        this.wishPrice = wishPrice;
    }

    public void removeWishId(Long wishId) {
        if (wishId.equals(this.wishId)) {
            
        }
    }


}
