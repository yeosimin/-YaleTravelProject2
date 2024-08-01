package com.example.TravelWeb.service;

import com.example.TravelWeb.dto.ProductDTO;
import com.example.TravelWeb.dto.ProductDetailDTO;
import com.example.TravelWeb.entity.Product;
import com.example.TravelWeb.entity.ProductDetail;
import com.example.TravelWeb.repository.ProductRepository;
import com.example.TravelWeb.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        product.setProductFlag(true); // productFlag를 true로 설정
        productRepository.save(product);
    }

    // 새로운 메서드 추가
    public Product getProductByIdOrNull(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Optional<ProductDTO> getProductDTOById(Long id) {
        return productRepository.findById(id).map(this::convertToDTO);
    }

    public void incrementProductViews(Long productId) {
        Optional<Product> productOpt = productRepository.findById(productId);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setProductViews(product.getProductViews() + 1);
            productRepository.save(product);
        }
    }



    private ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductDescription(product.getProductDescription());
        productDTO.setProductImageUrl(product.getProductImageUrl());
        productDTO.setProductCreatedAt(product.getProductCreatedAt());
        productDTO.setProductUpdatedAt(product.getProductUpdatedAt());
        productDTO.setProductIsInternational(product.getProductIsInternational());
        productDTO.setProductFlag(product.getProductFlag());
        productDTO.setProductPlaceOfDeparture(product.getProductPlaceOfDeparture());
        productDTO.setProductViews(product.getProductViews());


        // ProductDetail을 ProductDetailDTO로 변환하여 설정
        List<ProductDetailDTO> productDetailDTOs = productDetailRepository.findByProductId(product.getProductId()).stream()
                .map(this::convertToDetailDTO)
                .collect(Collectors.toList());
        productDTO.setProductDetails(productDetailDTOs);

        return productDTO;
    }

    private ProductDetailDTO convertToDetailDTO(ProductDetail productDetail) {
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();
        productDetailDTO.setProductDetailId(productDetail.getProductDetailId());
        productDetailDTO.setProductId(productDetail.getProductId());
        productDetailDTO.setProductDetailFirstDay(productDetail.getProductDetailFirstDay());
        productDetailDTO.setProductDetailLastDay(productDetail.getProductDetailLastDay());
        productDetailDTO.setProductDetailTotalCount(productDetail.getProductDetailTotalCount());
        productDetailDTO.setProductAdultPrice(productDetail.getProductAdultPrice());
        productDetailDTO.setProductTeenagerPrice(productDetail.getProductTeenagerPrice());
        productDetailDTO.setProductInfantPrice(productDetail.getProductInfantPrice());
        productDetailDTO.setProductDetailAirplane(productDetail.getProductDetailAirplane());
        return productDetailDTO;
    }
}
