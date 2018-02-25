package com.application.PortScanner.controller;

import com.application.PortScanner.service.PortService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Kevin Neag
 */
public class PortController {

    private PortService portService;

    @Autowired
    public void setPortService(PortService portService) {
        this.portService = portService;
    }
}
