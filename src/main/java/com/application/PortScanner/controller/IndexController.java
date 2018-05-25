package com.application.PortScanner.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    public IndexController() {
    }

    @RequestMapping({"","/","/index"})
    public String getIndex(){
        log.debug("Getting Index page");
        return "index";
    }
}
