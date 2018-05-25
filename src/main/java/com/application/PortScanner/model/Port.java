package com.application.PortScanner.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Port {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private int portNum;
    private String description;
}
