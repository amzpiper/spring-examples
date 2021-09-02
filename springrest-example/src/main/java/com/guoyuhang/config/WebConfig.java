package com.guoyuhang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@ComponentScan(basePackages = {"com.guoyuhang"})
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 配置JSP视图解析器
     * @return
     */
//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setExposeContextBeansAsAttributes(true);
//        resolver.setViewClass(JstlView.class);
//        return resolver;
//    }

    /**
     * 协商资源表述，注入ContentNegotiationManager
     * @return
     */
    @Bean
    public ViewResolver cnViewResolver(ContentNegotiationManager cnm) {
        ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
        cnvr.setContentNegotiationManager(cnm);
        return cnvr;
    }

    /**
     * 创建ContentNegotiationManager
     * @return
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }

    /**
     * 对静态资源的请求转发到Servlet容器中默认的Servlet上
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
