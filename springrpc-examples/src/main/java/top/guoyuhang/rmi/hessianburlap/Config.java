package top.guoyuhang.rmi.hessianburlap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import top.guoyuhang.rmi.spitter.SpitterService;

@Configuration
@ComponentScan
public class Config {

    @Bean
    public HessianServiceExporter hessianServiceExporter(SpitterService spitterService) {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(spitterService);
        exporter.setServiceInterface(SpitterService.class);
        return exporter;
    }
}
