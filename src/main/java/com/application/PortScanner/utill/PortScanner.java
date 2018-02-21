package com.application.PortScanner.utill;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Kevin Neag
 */


public class PortScanner {

    public void scan() throws Exception {

        String host = "localhost";

        InetAddress inetAddress = InetAddress.getByName(host);

        String hostName = inetAddress.getHostName();
        for (int port = 0; port <= 65535; port++) {
            try {
                Socket socket = new Socket(hostName, port);
                String text = hostName + " is listening on port " + port;
                System.out.println(text);
                socket.close();
            } catch (IOException e) {
                String s = hostName + " is not listening on port " + port;
                System.out.println(s);
            }
        }
    }
}
