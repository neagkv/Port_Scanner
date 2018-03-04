package com.application.PortScanner.controller;

import com.application.PortScanner.model.Port;
import com.application.PortScanner.service.PortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author Kevin Neag
 */
@Controller
public class PortController {

    private PortService portService;

    @Autowired
    public void setPortService(PortService portService) {
        this.portService = portService;
    }


    @RequestMapping(value = "/ports", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("ports", portService.listAllPorts());
        System.out.println("Returning ports:");
        return "ports";
    }

    @RequestMapping("port/{id}")
    public String showPort(@PathVariable Integer id, Model model){
        model.addAttribute("port", portService.getPortById(id));
        return "portshow";
    }

    @RequestMapping(value = "port", method = RequestMethod.POST)
    public String savePort(Port port){

        portService.savePort(port);

        return "redirect:/port/" + port.getId();
    }

    @RequestMapping("port/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("port", portService.getPortById(id));
        return "portform";
    }

    @RequestMapping("port/new")
    public String newPort(Model model){
        model.addAttribute("port", new Port());
        return "portform";
    }

}
