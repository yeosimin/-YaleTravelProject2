package com.example.TravelWeb.dto.history;

import lombok.Builder;
import lombok.Data;

@Data
//조회내역 사이트 들어갈때 데이터 불러오기
public class HistoryResponse {
    private String src;
    private String productName;
    private int productPrice;


    @Builder
    public HistoryResponse(String src, String productName, int productPrice) {
        this.src = src;
        this.productName = productName;
        this.productPrice = productPrice;
    }
}
