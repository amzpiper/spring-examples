package top.guoyuhang.client;

import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import top.guoyuhang.hessian.HessianServlet;
import top.guoyuhang.rmi.spitter.SpitterService;

public class InvokerClient {
    @Bean
    public HttpInvokerProxyFactoryBean hessianProxyFactoryBean() {
        HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
        proxy.setServiceUrl("http://localhost:8080/invoker");
        proxy.setServiceInterface(SpitterService.class);
        return proxy;
    }
}
