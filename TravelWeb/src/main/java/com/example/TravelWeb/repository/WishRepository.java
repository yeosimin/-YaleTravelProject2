package com.example.TravelWeb.repository;

import com.example.TravelWeb.entity.Wish;
import org.checkerframework.checker.nullness.Opt;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface WishRepository extends JpaRepository<Wish,Long> {
    Optional<List<Wish>> findAllByUserId(Long userId);


    // 쿼리 메서드(Query Method)라는 기능을 통해 메서드 이름을 해석하여 자동으로 SQL 쿼리를 생성하고 실행함
    //메서드 이름에 existsBy를 붙이면, 메서드 이름 뒤에 나오는 조건에 맞는 레코드가 있는지 검사하는 쿼리를 자동으로 생성함.
    boolean existsByUserIdAndProductDetailId(Long userId, Long productDetailId);

}
