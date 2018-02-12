package com.application.PortScanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Kevin Neag
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    String index(){
        return "index";
    }
}
