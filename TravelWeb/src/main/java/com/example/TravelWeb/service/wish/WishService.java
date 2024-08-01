package com.example.TravelWeb.service.wish;


import com.example.TravelWeb.dto.history.HistoryRequest;
import com.example.TravelWeb.dto.wish.WishRemoveRequest;
import com.example.TravelWeb.dto.wish.WishRequest;
import com.example.TravelWeb.dto.wish.WishResponse;
import com.example.TravelWeb.entity.Product;
import com.example.TravelWeb.entity.Wish;
import com.example.TravelWeb.repository.ProductRepository;
import com.example.TravelWeb.repository.WishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WishService {

    private final WishRepository wishRepository;
    private final ProductRepository productRepository;

    public Product findByProductId(Long productId) {
        return productRepository.findByProductId(productId)
                .orElseThrow(() -> new IllegalArgumentException("위시에서 product를 찾을 수 없음"));
    }

    public List<Wish> findAllByUserId(Long userId) {
        return wishRepository.findAllByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("not found wish"));

    }
    public Boolean existsByUserIdAndProductDetailId(Long userId, Long productDetailId) {
        return wishRepository.existsByUserIdAndProductDetailId(userId,productDetailId);
    }



    //위시리스트 보기
    public List<WishResponse> wishView() {
//    public List<WishRequest> wishView(WishRequest wishRequest) {
        System.out.println("입장");

//      List<Wish> wishes =  findAllByUserId(wishRequest.getUserId());
        //userId에 맞는 wish_Table레코드 추출
        List<Wish> wishes = findAllByUserId(1L);
        //wishes안에 있는 productId로


        List<WishResponse> request = new ArrayList<>();
        wishes.forEach(wish -> {
            request.add( WishResponse.builder()
                    .userId(wish.getUserId())
                    .wishName(wish.getWishName())
                    .wishPrice(wish.getWishPrice())
                    .productId(wish.getProductId())
//                            .src()
//                            .product_detail_firstday()
                    .build());
        });
        return request;

    }


    //위시에 넣기  TODO
    public WishRequest wishPush(WishRequest wishRequest) {

        ZonedDateTime now = ZonedDateTime.now();//현재시간

        //중복처리   userID와 productDetailID가 같은 레코드가 있으면 중복으로 인식
        Boolean exists = existsByUserIdAndProductDetailId(wishRequest.getUserId(), wishRequest.getProductDetailId());

        WishRequest request = new WishRequest(
                wishRequest.getUserId(), wishRequest.getProductId(), wishRequest.getProductDetailId(),
                now, wishRequest.getWishName(), wishRequest.getWishPrice()
        );

        //만약 중복이 아니라면
        if (!exists) {
            wishRepository.save(Wish.builder()
                    .userId(request.getUserId())
                    .productDetailId(request.getProductDetailId())
                    .productId(request.getProductId())
                    .wishDate(now)
                    .wishName(request.getWishName())
                    .wishPrice(request.getWishPrice())
                    .build());
        }else {
            throw new IllegalArgumentException("중복된 상품입니다!");
        }


        return request;

    }

    //위시삭제
    public WishRemoveRequest wishRemove(WishRemoveRequest removeRequest) {

        WishRemoveRequest request = new WishRemoveRequest(removeRequest.getWishId());




        return request;
    }



}
