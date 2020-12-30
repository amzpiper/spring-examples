package com.guoyuhang.config;

import com.guoyuhang.filter.EmailFilter;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class FilterInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        FilterRegistration.Dynamic myFilter = servletContext.addFilter("emailFilter", EmailFilter.class);
        myFilter.addMappingForUrlPatterns(null,false,"/email/*");
    }
}
