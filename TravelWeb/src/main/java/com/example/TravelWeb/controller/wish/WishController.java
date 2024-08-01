package com.example.TravelWeb.controller.wish;

import com.example.TravelWeb.dto.wish.WishRequest;
import com.example.TravelWeb.service.wish.WishService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class WishController {

    private final WishService wishService;

    @GetMapping("/wish")
    public String wishlist(Model model) {

        model.addAttribute("wishPut",wishService.wishView());
        return "/user/wish";
    }

    @PostMapping("/wishPut")
    public String wishput() {
//        wishService.wishPush();

        return "redirect/wish";
    }





}
