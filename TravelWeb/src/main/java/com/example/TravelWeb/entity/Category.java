package com.example.TravelWeb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "category_table") // 테이블 이름을 명시합니다.
public class Category {//

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id") // 컬럼 이름을 명시합니다.
    private Long categoryId;

    @Column(name = "category_name") // 컬럼 이름을 명시합니다.
    private String categoryName;//



}
