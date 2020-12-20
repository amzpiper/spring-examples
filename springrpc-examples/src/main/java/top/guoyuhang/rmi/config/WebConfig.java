package top.guoyuhang.rmi.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import top.guoyuhang.rmi.spitter.Spitter;
import top.guoyuhang.rmi.spitter.SpitterService;

import java.util.List;

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

    @Bean
    public SpitterService spitterService() {
        return new SpitterService() {
            @Override
            public List<Spitter> getRecentSpitters() {
                return null;
            }

            @Override
            public void saveSpitter(Spitter spitter) {

            }

            @Override
            public Spitter getSpitter(long id) {
                return null;
            }
        };
    }
}
