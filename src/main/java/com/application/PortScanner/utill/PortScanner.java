package com.application.PortScanner.utill;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author Kevin Neag
 */

/**
 * Scanner Class that scans the localhost for all listening ports
 */
public class PortScanner {

    //array list of all port numbers listening
    ArrayList<Integer> portsList;

    /**
     * Scan method that scans the localhost for open ports
     * @return ArrayList of listening ports
     * @throws Exception
     */
    public ArrayList<Integer> scan() throws Exception {

        //local host
        String host = "localhost";
        //get the internet address of localhost
        InetAddress inetAddress = InetAddress.getByName(host);


        String hostName = inetAddress.getHostName();
        //connect to each socket 0-65535 one by one to see if the port is listening and returns
        //array list of all ports that are working
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
