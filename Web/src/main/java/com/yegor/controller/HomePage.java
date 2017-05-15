package com.yegor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YegorKost on 15.05.2017.
 */
@Controller
public class HomePage {

    @RequestMapping(value = "/auctions")
    public String home() {
        return "home";
    }
}
