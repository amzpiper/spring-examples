package spittr.config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyServletInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //自定义Servlet
        ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", Myservlet.class);
        myServlet.addMapping("/custom/**");

        //自定义Filter
        FilterRegistration.Dynamic filter = servletContext.addFilter("myFilter", MyFilter.class);
        filter.addMappingForServletNames(null, false, "/custom/*");
    }
}
