package com.application.PortScanner.utill;

/**
 * @author Kevin Neag
 */
public enum PortCatalog {

    PORT20(20,"FTP","data transfer"),
    PORT21(21,"FTP",""),
    PORT22(22,"SSH",""),
    PORT23(23,"TELNET",""),
    PORT25(25,"smtp",""),
    PORT53(53,"domain",""),
    PORT67(67,"bootps",""),
    PORT68(68,"bootpc",""),
    PORT69(69,"tftp",""),
    PORT80(80,"http",""),
    PORT110(110,"pop3",""),
    PORT111(111,"sunprc",""),
    PORT139(139,"Netbios-ssn",""),
    PORT143(143,"imap",""),
    PORT161(161,"snmp",""),
    PORT179(179,"bgp",""),
    PORT194(194,"irc",""),
    PORT389(389,"idap",""),
    PORT443(443,"https",""),
    PORT631(631,"ipp",""),
    PORT1512(1512,"wins",""),
    PORT2049(2049,"nfsd",""),
    PORT3128(3128,"squid","");


    private Integer portNum;
    private String name;
    private String description;

    PortCatalog(Integer i, String ftp, String s) {
    }

    public Integer getPortNum() {
        return portNum;
    }

    public void setPortNum(Integer portNum) {
        this.portNum = portNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
