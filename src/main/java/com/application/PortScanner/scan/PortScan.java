package com.application.PortScanner.scan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;

@Component
@Slf4j
public class PortScan {

    private ArrayList<Integer> openPorts;

    public ArrayList<Integer> Scan (){

        for (int port = 1; port <= 65535; port++) {

            try {

                Socket socket = new Socket();
                socket.connect(new InetSocketAddress("localhost", port), 1000);
                socket.close();
                log.debug("Port " + port + " is open");
                openPorts.add(port);


            } catch (Exception ex) {
            }

        }
        log.debug("Scan complete");
        log.debug(openPorts.toString());

        return openPorts;
    }

}
