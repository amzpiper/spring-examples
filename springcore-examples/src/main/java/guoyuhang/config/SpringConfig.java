package guoyuhang.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringConfig {

    public void initConfigFileSystem(){
        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\Programming\\spring\\spring-examples\\src\\main\\java\\top\\guoyuhang\\config\\knight.xml");
    }

    public void initConfigClassPathXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("knight.xml");
    }

    public void initConfigAnnotation(){
        ApplicationContext context = new AnnotationConfigApplicationContext("top.guoyuhang.config.knight");
    }

//WebConfig
//    public void initConfigAnnotationWeb(){
//        ApplicationContext context = new AnnotationConfigWebApplicationContext();
//    }

//    public void initConfigXmlWeb() {
//        ApplicationContext context = new XmlWebApplicationContext();
//    }

}
