package com.example.TravelWeb.repository;

import com.example.TravelWeb.entity.Product;
import com.example.TravelWeb.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductFlag(Boolean productFlag);

    //세정 ) 위시에 넣기 위해 /
    Optional<Product> findByProductId(Long productId);





}
