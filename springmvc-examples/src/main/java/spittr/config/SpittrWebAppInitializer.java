package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

    /**
     * 将DispatcherServlet映射到"/"
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 配置ContextLoaderListener创建的bean
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * 定义DispatcherServlet的bean
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * 配置文件上传
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setLoadOnStartup(1);
        registration.setMultipartConfig(new MultipartConfigElement("/tmp/spittr/uploads",2097152,4194304,0));
    }


    /**
     * 注册Filter
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {new MyFilter()};
    }
}
