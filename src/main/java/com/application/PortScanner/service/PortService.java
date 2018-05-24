package com.application.PortScanner.service;

import com.application.PortScanner.model.Port;

import java.util.Set;

public interface PortService {

    Set<Port> getPorts();

    Port findById(Long l);
}
