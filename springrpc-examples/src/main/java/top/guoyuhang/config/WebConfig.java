package top.guoyuhang.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import top.guoyuhang.spitter.SpitterService;

@ComponentScan(basePackages = "top.guoyuhang")
@Configuration
//@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置JSP视图解析器
     *
     * @return
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
     * @return
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
}
