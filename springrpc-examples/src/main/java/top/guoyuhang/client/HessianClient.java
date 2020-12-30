package top.guoyuhang.client;

import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import top.guoyuhang.hessian.HessianServlet;

public class HessianClient {
    @Bean
    public HessianProxyFactoryBean hessianProxyFactoryBean() {
        HessianProxyFactoryBean proxy = new HessianProxyFactoryBean();
        proxy.setServiceUrl("http://localhost:8080/Spitter/hessian");
        proxy.setServiceInterface(HessianServlet.class);
        return proxy;
    }
}
