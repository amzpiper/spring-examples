package top.guoyuhang.client;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.guoyuhang.config.SpitterAppInitalizer;
import top.guoyuhang.rmi.spitter.SpitterService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpitterAppInitalizer.class,ClientConfig.class})
//@ContextConfiguration(classes = {ClientConfig.class})
@ActiveProfiles("dev")
public class RMIClient {

    @Test
    public void TestGetRMIService() {
        //ApplicationContext context = new AnnotationConfigApplicationContext(ClientConfig.class);
        try {
            String serviceUrl = "rmi:///SpitterService";
            SpitterService spitterService = (SpitterService) Naming.lookup(serviceUrl);

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
