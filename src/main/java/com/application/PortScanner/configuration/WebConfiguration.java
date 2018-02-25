package com.application.PortScanner.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author Kevin Neag
 */


@Configuration
public class WebConfiguration {

        @Bean
        public ServletRegistrationBean h2servletRegistration() {
            ServletRegistrationBean registration = new ServletRegistrationBean(new org.h2.server.web.WebServlet());
            registration.addUrlMappings("/console/*");
            return registration;
        }
    }

