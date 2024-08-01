package com.example.TravelWeb.controller;

import com.example.TravelWeb.dto.ProductDTO;
import com.example.TravelWeb.dto.ProductDetailDTO;
import com.example.TravelWeb.entity.Product;
import com.example.TravelWeb.service.ProductDetailService;
import com.example.TravelWeb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class StoreController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("/store")
    public String viewStore(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "store";
    }

    @GetMapping("/store/{id}")
    public String viewProductDetail(@PathVariable("id") Long id, Model model) {
        productService.incrementProductViews(id); // 조회수 증가

        Optional<ProductDTO> productOpt = productService.getProductDTOById(id);
        if (productOpt.isPresent()) {
            ProductDTO product = productOpt.get();
            model.addAttribute("product", product);
            model.addAttribute("productDetails", product.getProductDetails());
        } else {
            return "redirect:/store"; // 상품을 찾지 못한 경우 리다이렉트
        }
        return "productDetail"; // 상세 페이지 템플릿 이름
    }


}
