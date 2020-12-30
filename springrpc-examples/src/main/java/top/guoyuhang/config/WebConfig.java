package top.guoyuhang.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import top.guoyuhang.hessian.HessianServlet;
import top.guoyuhang.rmi.spitter.Spitter;
import top.guoyuhang.rmi.spitter.SpitterService;
import top.guoyuhang.rmi.spitter.SpitterServiceImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

@ComponentScan(basePackages = "top.guoyuhang")
@Configuration
//@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置JSP视图解析器
     * @return ViewResolver
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    /**
     * RmiServiceExporter把Bean发布为RMI服务
     * 默认绑定本地1099端口上的RMI注册表
     * @param spitterService
     * @return RmiServiceExporter
     */
    @Bean
    public RmiServiceExporter rmiServiceExporter(SpitterService spitterService) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(spitterService);
        rmiServiceExporter.setServiceName("SpitterService");
        rmiServiceExporter.setServiceInterface(SpitterService.class);
        rmiServiceExporter.setRegistryHost("top.guoyuhang");
        rmiServiceExporter.setRegistryPort(1199);
        return rmiServiceExporter;
    }
    @Bean
    public SpitterService spitterService() {
        return new SpitterServiceImpl();
    }

    /**
     * HessianServiceExporter把Bean发布为RMI服务
     * @param hessianServlet
     * @return HessianServiceExporter
     */
    public HessianServiceExporter hessianServiceExporter(HessianServlet hessianServlet) {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(hessianServlet);
        exporter.setServiceInterface(HessianServlet.class);
        return exporter;
    }
    @Bean
    public HandlerMapping hessianMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties properties = new Properties();
        properties.setProperty("/hessian", "hessianServiceExporter");
        mapping.setMappings(properties);
        return mapping;
    }

    /**
     * HttpInvokerServiceExporter把Bean发布为RMI服务
     * @param spitterService
     * @return HttpInvokerServiceExporter
     */
    @Bean
    public HttpInvokerServiceExporter httpInvokerServiceExporter(SpitterService spitterService) {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(spitterService);
        exporter.setServiceInterface(SpitterService.class);
        return exporter;
    }
    @Bean
    public HandlerMapping invokerMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties properties = new Properties();
        properties.setProperty("/invoker", "httpInvokerServiceExporter");
        mapping.setMappings(properties);
        return mapping;
    }

    /**
     * JAX-WS发布rmi服务:自动找带有webservice注解的类
     * @return SimpleJaxWsServiceExporter
     */
    @Bean
    public SimpleJaxWsServiceExporter jaxWsServiceExporter() {
        return new SimpleJaxWsServiceExporter();
    }

    /**
     * 使用JAX-WS发布rmi的服务
     * @return JaxWsPortProxyFactoryBean
     */
    @Bean
    public JaxWsPortProxyFactoryBean spitterService2() throws MalformedURLException {
        JaxWsPortProxyFactoryBean proxy = new JaxWsPortProxyFactoryBean();
        proxy.setWsdlDocumentUrl(new URL("http://localhost:8080/SpitterService"));
        proxy.setServiceName("SpitterService");
        proxy.setPortName("spitterServicePort");
        proxy.setServiceInterface(SpitterService.class);
        proxy.setNamespaceUri("http://spitter.com");
        return proxy;
    }
}
