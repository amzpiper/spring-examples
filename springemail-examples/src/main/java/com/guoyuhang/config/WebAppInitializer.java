package com.guoyuhang.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Servlet3.0，发现实现ServletContainerInitializer接口的类，自动用它来配置Servlet容器
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 根配置
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * DispatcherServlet配置类
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * 映射DispatcherServlet到 /
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 注册Filter映射到DispatcherServlet
     *
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        return super.getServletFilters();
    }
}
