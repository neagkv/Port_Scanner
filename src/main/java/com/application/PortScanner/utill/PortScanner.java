package com.application.PortScanner.utill;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author Kevin Neag
 */


public class PortScanner {

    ArrayList<Integer> portsList;

    public ArrayList<Integer> scan() throws Exception {

        String host = "localhost";
        InetAddress inetAddress = InetAddress.getByName(host);

        String hostName = inetAddress.getHostName();
        for (int port = 0; port <= 65535; port++) {
            try {
                Socket socket = new Socket(hostName, port);
                String text = hostName + " is listening on port " + port;
                portsList.add(port);
                socket.close();
            } catch (IOException e) {
            }
        }
        return portsList;
    }
}
