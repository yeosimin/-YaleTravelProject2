package com.example.TravelWeb.controller;

import com.example.TravelWeb.dto.ProductDetailDTO;
import com.example.TravelWeb.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productdetails")
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping
    public String getAllProductDetails(Model model) {
        List<ProductDetailDTO> productDetails = productDetailService.getAllProductDetails();
        model.addAttribute("productDetails", productDetails);
        return "productdetails/list";
    }

    @GetMapping("/{id}")
    public String getProductDetailById(@PathVariable Long id, Model model) {
        ProductDetailDTO productDetail = productDetailService.getProductDetailById(id);
        model.addAttribute("productDetail", productDetail);
        return "productdetails/detail";
    }

    @GetMapping("/create")
    public String createProductDetailForm(Model model) {
        model.addAttribute("productDetail", new ProductDetailDTO());
        return "productdetails/form";
    }

    @PostMapping
    public String saveProductDetail(@ModelAttribute("productDetail") ProductDetailDTO productDetailDTO) {
        productDetailService.saveProductDetail(productDetailDTO);
        return "redirect:/productdetails";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductDetail(@PathVariable Long id) {
        productDetailService.deleteProductDetail(id);
        return "redirect:/productdetails";
    }
}