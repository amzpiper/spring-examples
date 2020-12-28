package top.guoyuhang.jaxws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import top.guoyuhang.rmi.spitter.Spitter;
import top.guoyuhang.rmi.spitter.SpitterService;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Component
@WebService(serviceName = "SpitterService")
public class SpitterServiceEndpoint {

    //发布到localhost:8080/SpitterService
    @Autowired
    SpitterService spitterService;

    @WebMethod
    public void addSpitter(Spitter spitter) {

    }

}
