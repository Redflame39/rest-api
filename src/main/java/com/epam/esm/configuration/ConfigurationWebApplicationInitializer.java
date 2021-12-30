package com.epam.esm.configuration;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;

public class ConfigurationWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        servletContext.setInitParameter("spring.profiles.active", "prod");
    }
}