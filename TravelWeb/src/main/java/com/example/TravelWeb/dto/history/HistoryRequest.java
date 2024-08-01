package com.example.TravelWeb.dto.history;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
//조회내역 데이터 받아서 컨트롤러에 넘기기
public class HistoryRequest {

    private Long productId;
    private Long productDetailId;//만약 위시나 결제를 할때
    private ZonedDateTime productDate;

    //올리브영 처럼 방금 찾으시 이 상품과 함꼐 많이 본 상품을 할 수 있지 않을까? productID와 PorudctDetialID를 통해
    //



    @Builder
    public HistoryRequest(Long productId, Long productDetailId, ZonedDateTime productDate) {
        this.productId = productId;
        this.productDetailId = productDetailId;
        this.productDate = productDate;
    }
}
