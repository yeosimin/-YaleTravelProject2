package com.example.TravelWeb.service;

import com.example.TravelWeb.dto.ProductDetailDTO;
import com.example.TravelWeb.entity.ProductDetail;
import com.example.TravelWeb.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductDetailService {
    @Autowired
    private ProductDetailRepository productDetailRepository;

    private ProductDetailDTO convertToDTO(ProductDetail productDetail) {
        if (productDetail == null) {
            return null;
        }
        ProductDetailDTO dto = new ProductDetailDTO();
        dto.setProductDetailId(productDetail.getProductDetailId());
        dto.setProductId(productDetail.getProductId());
        dto.setProductDetailFirstDay(productDetail.getProductDetailFirstDay());
        dto.setProductDetailLastDay(productDetail.getProductDetailLastDay());
        dto.setProductDetailTotalCount(productDetail.getProductDetailTotalCount());
        dto.setProductAdultPrice(productDetail.getProductAdultPrice());
        dto.setProductTeenagerPrice(productDetail.getProductTeenagerPrice());
        dto.setProductInfantPrice(productDetail.getProductInfantPrice());
        dto.setProductDetailAirplane(productDetail.getProductDetailAirplane());
        return dto;
    }

    private ProductDetail convertToEntity(ProductDetailDTO dto) {
        if (dto == null) {
            return null;
        }
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductDetailId(dto.getProductDetailId());
        productDetail.setProductId(dto.getProductId());
        productDetail.setProductDetailFirstDay(dto.getProductDetailFirstDay());
        productDetail.setProductDetailLastDay(dto.getProductDetailLastDay());
        productDetail.setProductDetailTotalCount(dto.getProductDetailTotalCount());
        productDetail.setProductAdultPrice(dto.getProductAdultPrice());
        productDetail.setProductTeenagerPrice(dto.getProductTeenagerPrice());
        productDetail.setProductInfantPrice(dto.getProductInfantPrice());
        productDetail.setProductDetailAirplane(dto.getProductDetailAirplane());
        return productDetail;
    }

    public List<ProductDetailDTO> getAllProductDetails() {
        return productDetailRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    public ProductDetailDTO getProductDetailById(Long id) {
        return productDetailRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public ProductDetailDTO saveProductDetail(ProductDetailDTO dto) {
        try {
            ProductDetail productDetail = convertToEntity(dto);
            return convertToDTO(productDetailRepository.save(productDetail));
        } catch (Exception e) {
            // 로깅 추가
            System.err.println("Error saving product detail: " + e.getMessage());
            return null;
        }
    }

    public void deleteProductDetail(Long id) {
        if (productDetailRepository.existsById(id)) {
            productDetailRepository.deleteById(id);
        } else {
            // 로깅 추가
            System.err.println("Product detail with ID " + id + " not found.");
        }
    }
}
