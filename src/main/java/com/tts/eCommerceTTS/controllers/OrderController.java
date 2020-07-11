package com.tts.eCommerceTTS.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/storefront")
public class OrderController {
  @GetMapping("/order")
  public String getOrderPage(){
    //code
    return "storefront/order";
  }
}