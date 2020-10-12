package com.furseal.restaurant.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toIndex(HttpSession session) {
        return "/index";
    }
}
