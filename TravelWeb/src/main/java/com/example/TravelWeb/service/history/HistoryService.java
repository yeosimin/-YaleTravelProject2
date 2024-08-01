package com.example.TravelWeb.service.history;

import com.example.TravelWeb.dto.history.HistoryRequest;
import com.example.TravelWeb.dto.history.HistoryResponse;
import com.example.TravelWeb.entity.History;
import com.example.TravelWeb.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepository historyRepository;


    public List<History> findAllByUserId(Long userId) {
        return historyRepository.findAllByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("너는 조회기록을 찾을 수 없다"));
    }



    //조회내역 view보기
    public List<HistoryResponse> historyView(HistoryResponse historyResponse) {

        List<History> histories = findAllByUserId(1L);

        List<HistoryResponse> response = new ArrayList<>();

        histories.forEach(history -> {
                response.add(
                        HistoryResponse.builder()
//                                .src()
                                .productName(historyResponse.getProductName())
                                .productPrice(historyResponse.getProductPrice())
                                .build());
                });
        return response;
    }




    //조회내역에 추가하기
    public HistoryRequest historyPush(HistoryRequest historyRequest) {

        ZonedDateTime now = ZonedDateTime.now();

        //받아온 historyRequest로 HistoryRequest dto 데이터 채우기
        HistoryRequest request = new HistoryRequest(
                historyRequest.getProductId(), historyRequest.getProductDetailId(),now);

        //엔티티에 dto값 넣기
      historyRepository.save(History.builder()
                      .productDetailId(request.getProductDetailId())
                      .productId(request.getProductId())
                      .productDate(now)
              .build());
        return request;
    }




}
