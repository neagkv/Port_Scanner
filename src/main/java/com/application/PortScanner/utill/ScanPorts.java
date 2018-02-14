package com.application.PortScanner.utill;

import java.net.InetSocketAddress;
import java.net.Socket;


/**
 * @author Kevin Neag
 */

public class ScanPorts {

    public static void main(String []args) {

        for (int port = 1; port <= 65535; port++) {

            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress("localhost", port), 1000);
                socket.close();
                System.out.println("Port " + port + " is open");

            } catch (Exception ex) {

            }
        }
    }
}

