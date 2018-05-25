package com.application.PortScanner.bootstrap;

import com.application.PortScanner.model.Port;
import com.application.PortScanner.repository.PortRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class PortBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final PortRepository portRepository;

    public PortBootstrap(PortRepository portRepository) {
        this.portRepository = portRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        portRepository.saveAll(getPorts());
        log.debug("Loading Bootstrap Data");
    }

    private List<Port> getPorts() {

        List<Port> ports = new ArrayList<>(2);

        Port httpProxy = new Port();
        httpProxy.setPortNum(8080);
        httpProxy.setDescription("HTTP proxy");
        ports.add(httpProxy);



        return ports;
    }


}
