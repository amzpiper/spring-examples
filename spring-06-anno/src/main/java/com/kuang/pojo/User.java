package com.kuang.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author guoyh
 */
//等价于注册一个bean
@Component
public class User {

    //相当于bean里的property中的配置属性值
    @Value("秦将")
    public String name;

    @Value("秦将")
    public void setName(String name) {
        this.name = name;
    }
}
