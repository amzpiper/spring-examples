package top.guoyuhang.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import top.guoyuhang.spitter.Spitter;
import top.guoyuhang.spitter.SpitterService;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "top.guoyuhang")
public class ClientConfig {

    @Bean
    public RmiProxyFactoryBean spitterService() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost/SpitterService");
        rmiProxyFactoryBean.setServiceInterface(SpitterService.class);
        return rmiProxyFactoryBean;
    }

}
