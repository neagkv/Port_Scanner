package com.application.PortScanner.service;

import com.application.PortScanner.model.Port;
import com.application.PortScanner.repository.PortRepository;
import com.application.PortScanner.scan.PortScan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class PortServiceImpl implements PortService {

    private final PortRepository portRepository;
    private final PortScan portScan;

    public PortServiceImpl(PortRepository portRepository, PortScan portScan) {
        this.portRepository = portRepository;
        this.portScan = portScan;
    }

    @Override
    public Set<Port> getPorts() {
        log.debug("service: Scanning ports");
        portScan.Scan();
        Set<Port> portSet = new HashSet<>();
        portRepository.findAll().iterator().forEachRemaining(portSet::add);
        return portSet;


    }

    @Override
    public Port findById(Long l) {
        return null;
    }
}
