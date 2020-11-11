package com.furseal.restaurant.main.controller;

import com.furseal.restaurant.main.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
@Controller
public class MainController {
    @Autowired
    private AlipayService alipayService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toIndex(HttpSession session) {
        return "/index";
    }

    @RequestMapping(value = "/getQrUlr", method = RequestMethod.GET)
    @ResponseBody
    public String getQrUlr(){
        String qrUrl = alipayService.getQrUrl();
        return qrUrl;
    }
}
