package com.application.PortScanner.bootstrap;

import com.application.PortScanner.model.Port;
import com.application.PortScanner.repository.PortRepository;
import com.application.PortScanner.utill.PortScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

/**
 * @author Kevin Neag
 */

@Component
public class PortCatalogLoader implements ApplicationListener<ContextRefreshedEvent> {

    private PortRepository portRepository;
    private PortScanner portScanner;
    private Logger log = Logger.getLogger(PortCatalogLoader.class);

    public PortCatalogLoader(PortRepository portRepository, PortScanner portScanner) {
        this.portRepository = portRepository;
        this.portScanner = portScanner;
    }

    @Autowired
    public void setPortRepository(PortRepository portRepository) {
        this.portRepository = portRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Port http = new Port();
        http.setPortNum(8080);
        http.setName("HTTP Proxy");
        http.setDescription("Alternative web server");
        portRepository.save(http);
        log.info("Saved Http - id : " + http.getId());

        Port intellij = new Port();
        intellij.setPortNum(63342);
        intellij.setName("IntelliJ");
        intellij.setDescription("IDEA");
        portRepository.save(intellij);
        log.info("Saved Mysql - id : " + intellij.getId());

        try {
            portScanner.scan();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}

