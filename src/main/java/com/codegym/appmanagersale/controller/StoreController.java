package com.codegym.appmanagersale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
public class StoreController {
    @RequestMapping("")
    public String showStore() {
        return "/user/store";
    }
}
