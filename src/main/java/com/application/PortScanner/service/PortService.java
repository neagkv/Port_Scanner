package com.application.PortScanner.service;

import com.application.PortScanner.model.Port;
import com.application.PortScanner.utill.PortScanner;

import java.util.ArrayList;

/**
 * @author Kevin Neag
 */



public interface PortService {

    Iterable<Port> listAllPorts();

    Port getPortById(Integer id);

    Port savePort(Port port);


}
