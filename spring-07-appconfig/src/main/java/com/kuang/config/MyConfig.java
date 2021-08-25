package com.kuang.config;

import com.kuang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//Configuration本身就是Component,这个类也会注册到IOC容器,Configuration代表着是一个配置类，就是beans.xml
@Configuration
@ComponentScan("com.kuang")
//引入配置类
//@Import(MyConfig.class)
public class MyConfig {

    //方法名=bean.id
    //注册一个bean相当于之前写的bean
    //方法的返回值相当于bean标签的class
    //name可以指定bean的name
    @Bean(name = "getUser2")
    public User getUser() {
        return new User();
    }
}
