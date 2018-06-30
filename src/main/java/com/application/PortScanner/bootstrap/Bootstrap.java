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
    private ArrayList<Port> portList;



    @Override
    public void run(String... args) throws Exception {

        //Executor service with 20 threads
        final ExecutorService es = Executors.newFixedThreadPool(20);
        //home ip
        final String ip = "127.0.0.1";
        //timeout of 200ms
        final int timeout = 200;
        //Arraylist of future ports
        final List<Future<Port>> futures = new ArrayList<>();
        //Arraylist of future open ports
        final List<Future<Port>> openFutures = new ArrayList<>();
        log.debug("Starting Scan");
        //for each port
        for (int port = 22; port <= 23; port++) {
            //futures add to see if port is open
            futures.add(portIsOpen(es, ip, port, timeout));
        }
        //terminate threads after 200ms
        es.awaitTermination(200L, TimeUnit.MILLISECONDS);
        int openPorts = 0;
        //for each future port
        for (final Future<Port> f : futures)
            //if the port is open
            if (f.get().isOpen()) {
            openFutures.add(f);

                //print out the value of port
                log.debug(String.valueOf(f.get().getPortNum()));
                openPorts++;

            }

        log.debug("There are " + openPorts + " open ports on host " + ip + " (probed with a timeout of "
                + timeout + "ms)");

//        for(final Future<Port> openFuture : openFutures){
//            long id =1;
//            Port port1 = new Port(id,openFuture.get().getPortNum(),true);
//            portList.add(port1);
//            log.debug(portList.toString());
//            id++;

    }

    //check if port is open and return
    public static Future<Port> portIsOpen(final ExecutorService es, final String ip, final int port,
                                          final int timeout) {
        return es.submit(new Callable<Port>() {
            @Override
            public Port call() {
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(ip, port), timeout);
                    socket.close();
                    return new Port(port,true);
                } catch (Exception ex) {
                    return new Port(port,false);
                }
            }
        });

    }

    }













