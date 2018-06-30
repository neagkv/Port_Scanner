package com.application.PortScanner.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


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

    private int portNum;
    private boolean isOpen;

    public Port(int portNum, boolean isOpen) {
        this.portNum = portNum;
        this.isOpen = isOpen;
    }
}
