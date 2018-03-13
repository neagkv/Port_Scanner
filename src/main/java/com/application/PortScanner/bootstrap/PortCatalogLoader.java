package com.application.PortScanner.bootstrap;

import com.application.PortScanner.model.Port;
import com.application.PortScanner.repository.PortRepository;
import com.application.PortScanner.utill.PortScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * @author Kevin Neag
 */

@Component
public class PortCatalogLoader implements ApplicationListener<ContextRefreshedEvent> {

    private PortRepository portRepository;

    private Logger log = Logger.getLogger(PortCatalogLoader.class);


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

        Port mysql = new Port();
        mysql.setPortNum(3306);
        mysql.setName("MySQL");
        mysql.setDescription("Database");
        portRepository.save(mysql);
        log.info("Saved Mysql - id : " + mysql.getId());
    }
}

