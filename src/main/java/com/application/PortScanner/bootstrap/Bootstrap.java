package com.application.PortScanner.bootstrap;

import com.application.PortScanner.domain.Port;
import com.application.PortScanner.reposiotory.PortRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Kevin Neag
 */

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private PortRepository portRepository;



    @Override
    public void run(String... args) throws Exception {

        final ExecutorService es = Executors.newFixedThreadPool(20);
        final String ip = "127.0.0.1";
        final int timeout = 200;
        final List<Future<Port>> futures = new ArrayList<>();
        log.debug("Starting Scan");
        for (int port = 22; port <= 5535; port++) {

            futures.add(portIsOpen(es, ip, port, timeout));
        }
        es.awaitTermination(200L, TimeUnit.MILLISECONDS);
        int openPorts = 0;
        for (final Future<Port> f : futures)
            if (f.get().isOpen()) {
                log.debug(String.valueOf(f.get().getPortNum()));
                openPorts++;

            }

        log.debug("There are " + openPorts + " open ports on host " + ip + " (probed with a timeout of "
                + timeout + "ms)");

    }

    public static Future<Port> portIsOpen(final ExecutorService es, final String ip, final int port,
                                          final int timeout) {
        return es.submit(new Callable<Port>() {
            @Override
            public Port call() {
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(ip, port), timeout);
                    socket.close();
                    return new Port(port, true);
                } catch (Exception ex) {
                    return new Port(port,false);
                }
            }
        });
    }

}





