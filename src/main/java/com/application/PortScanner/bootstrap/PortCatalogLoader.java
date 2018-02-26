package com.application.PortScanner.bootstrap;

import com.application.PortScanner.model.Port;
import com.application.PortScanner.repository.PortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

/**
 * @author Kevin Neag
 */

@Component
public class PortCatalogLoader {

    private PortRepository portRepository;

    private Logger log = Logger.getLogger(PortCatalogLoader.class);

    @Autowired
    public void setPortRepository(PortRepository portRepository) {
        this.portRepository = portRepository;
    }


    public void onApplicationEvent(ContextRefreshedEvent event) {

        Port http = new Port();
        http.setPortNum(8080);
        http.setName("HTTP Proxy");
        http.setDescription("alternative web server");
        portRepository.save(http);
        log.info("Saved Http - id : " + http.getId());
    }


}
