package com.guoyuhang.config;

import com.guoyuhang.servlet.EmailServlet;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ServletInitializer implements WebApplicationInitializer {

    /**
     * 注册自定义Servlet
     *
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic myServlet = servletContext.addServlet("emailServlet", EmailServlet.class);
        myServlet.addMapping("/email/servlet");
    }

}
