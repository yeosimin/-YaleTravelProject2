package com.example.TravelWeb.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.ZonedDateTime;


@Entity
@Table(name = "history_table")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long historyId;

    @Column(name = "product_date")
    private ZonedDateTime productDate;//클릭날짜

    @Column(name = "product_id")
    private Long productId; //클릭한 상품

    @Column(name = "product_detail_id")
    private Long productDetailId; //클릭한 상품

    @Column(name = "user_id")
    private Long userId; //클릭한 상품


    @PrePersist//db에 저장되기전 실행되는 메서드
    public void onDateNow() {
        this.productDate = ZonedDateTime.now();//현재시간 추가
    }


    @Builder
    public History(Long historyId, ZonedDateTime productDate, Long productId, Long productDetailId) {
        this.historyId = historyId;
        this.productDate = productDate;
        this.productId = productId;
        this.productDetailId = productDetailId;
    }
}
