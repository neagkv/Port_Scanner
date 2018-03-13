package com.application.PortScanner.controller;

import com.application.PortScanner.service.PortService;
import com.application.PortScanner.utill.PortScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/**
 * @author Kevin Neag
 */
@Controller
public class ScanController {

    private PortService portService;
    @Autowired
    public void setPortService(PortService portService) {
        this.portService = portService;
    }


    @RequestMapping(value ="/scan", method = RequestMethod.GET)
    String scan(){
        return "scan";
    }


    @RequestMapping(value = "/ports", method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        model.addAttribute("ports", portService.listAllPorts());
        PortScanner portScanner = new PortScanner();
        ArrayList<Integer> usedPorts = portScanner.scan();
        System.out.println("Returning ports:");
        return "ports";
    }
}
