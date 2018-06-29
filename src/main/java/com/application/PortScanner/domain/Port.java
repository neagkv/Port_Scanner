package com.application.PortScanner.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author Kevin Neag
 */
@Data
@Entity
@NoArgsConstructor
public class Port {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Port portNum;
    private boolean portIsOpen;

    public Port(Port portNum, Boolean portIsOpen) {
        this.id = id;
        this.portNum = portNum;
        this.portIsOpen = portIsOpen;
    }

    public Port(Port portNum) {
        this.portNum = portNum;
    }

    public Port(int port) {
    }
}
