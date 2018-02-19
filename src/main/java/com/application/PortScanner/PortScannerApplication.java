package com.application.PortScanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PortScannerApplication {


	public static void main(String[] args) {
		SpringApplication.run(PortScannerApplication.class, args);
	}

}
