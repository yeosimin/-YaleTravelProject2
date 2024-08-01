package com.example.TravelWeb.controller.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class CustomErrorController  implements ErrorController {

    @RequestMapping("/error/404")
    public ModelAndView handleError() {
        ModelAndView modelAndView = new ModelAndView("error/404"); // error/404.html로 이동
        modelAndView.addObject("message", "페이지를 찾을 수 없습니다.");
        return modelAndView;
    }

    @RequestMapping("/error/500")
    public ModelAndView error500() {
        ModelAndView modelAndView = new ModelAndView("error/500");
        modelAndView.addObject("message","500에러, 내부코드 오류");
        System.out.println("500error");

        return modelAndView;
    }





 /*   @Override
    public String getErrorPath() {
        return "/error"; // 기본 에러 경로
    }*/


}
