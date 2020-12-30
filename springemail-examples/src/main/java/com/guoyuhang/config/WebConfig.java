package com.guoyuhang.config;

import com.guoyuhang.controller.EmailController;
import com.guoyuhang.jmx.ControllerManageOperation;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jmx.access.MBeanProxyFactoryBean;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.assembler.InterfaceBasedMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MethodNameBasedMBeanInfoAssembler;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.remote.JMXConnector;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.guoyuhang"})
public class WebConfig implements WebMvcConfigurer {

    /**
     * 配置视图解析器,解析为web应用内部资源
     *
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        //
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");
        viewResolver.setExposeContextBeansAsAttributes(true);
        return viewResolver;
    }

    /**
     * 静态资源处理，将静态资源的请求转发的Servlet容器默认的servlet上
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 简单配置MailSender
     * @param env
     * @return
     */
//    @Bean
//    public JavaMailSender mailSender(Environment env) {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.qq.com");
//        mailSender.setPort(587);
//        mailSender.setUsername("1131717341@qq.com");
//        mailSender.setPassword("");
//        Properties params = new Properties();
//        params.put("mail.smtp.auth", true);
//        params.put("mail.debug", false);
//        params.put("mail.smtp.timeout", 5000);
//        mailSender.setJavaMailProperties(params);
//        return mailSender;
//    }

    /**
     * JNDI中有已就绪的MailSession时
     * 从JNDI中查找MailSession
     * @return
     */
//    @Bean
//    public JndiObjectFactoryBean maillSession() {
//        JndiObjectFactoryBean jndi = new JndiObjectFactoryBean();
//        jndi.setJndiName("mail/Session");
//        //jndi.setProxyInterface(MaillSession.class);
//        jndi.setResourceRef(true);
//        return jndi;
//    }

    //使用模板神额过程Email
    //Velocity,注册bean
    //@Bean
    //public VelocityEngine velocityEngine() {
    //}

    /**
     * 将SpringBean导出为mbean
     * @param controller
     * @return
     */
    @Bean
    //MBeanInfoAssembler指定名称暴漏mbean
    //public MBeanExporter mBeanExporter(EmailController controller, MBeanInfoAssembler assembler) {
    public MBeanExporter mBeanExporter(EmailController controller,InterfaceBasedMBeanInfoAssembler assembler) {
//    public MBeanExporter mBeanExporter(EmailController controller) {
        MBeanExporter exporter = new MBeanExporter();
        Map<String, Object> beans = new HashMap<String, Object>();
        beans.put("email:name=EmailController", controller);
        exporter.setBeans(beans);
        //添加名称暴漏装配器
        //exporter.setAssembler(assembler);

        //接口暴漏装配器
        exporter.setAssembler(assembler);

        //解决暴漏名字域冲突
        //冲突后失败
        exporter.setRegistrationPolicy(RegistrationPolicy.FAIL_ON_EXISTING);
        //忽略冲突，不注册新的MBean
//        exporter.setRegistrationPolicy(RegistrationPolicy.IGNORE_EXISTING);
        //新的MBean覆盖旧的MBean
//        exporter.setRegistrationPolicy(RegistrationPolicy.REPLACE_EXISTING);
        return exporter;
    }

//    /**
//     * 名称暴漏方法
//     * @return
//     */
//    @Bean
//    public MethodNameBasedMBeanInfoAssembler assembler() {
//        MethodNameBasedMBeanInfoAssembler assembler = new MethodNameBasedMBeanInfoAssembler();
//        assembler.setManagedMethods(new String[]{"getMailName","getMailName2"});
//        return assembler;
//    }

    /**
     * 接口暴漏MBean
     * @return
     */
    @Bean
    public InterfaceBasedMBeanInfoAssembler assembler() {
        InterfaceBasedMBeanInfoAssembler assembler = new InterfaceBasedMBeanInfoAssembler();
        assembler.setManagedInterfaces(new Class<?>[]{ControllerManageOperation.class});
        return assembler;
    }

    //注解暴漏

    /**
     * xml
     * <context:mbean-export server="mbeanServer"/>
     * 类：
     * @ManagedResource(objectName="spitter:name=Controller")
     * 方法：
     * 暴漏属性
     * @ManageAttribut
     * 不暴漏属性
     * @ManageOperation
     */

    /**
     * 远程访问MBean
     * 默认端口9875
     * 地址：service:jmx:jmxmp://localhost:9875
     *
     * @return
     */
    @Bean
    public ConnectorServerFactoryBean connectorServerFactoryBean() {
        ConnectorServerFactoryBean csfb = new ConnectorServerFactoryBean();
        //自定义远程地址
        //绑定到RMI注册表，监听1099端口，下面创建RMI注册表
        csfb.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:1099/mbean");
        return csfb;
    }
    @Bean
    public RmiRegistryFactoryBean rmiRegistryFactoryBean() {
        RmiRegistryFactoryBean rmiRegistryFactoryBean = new RmiRegistryFactoryBean();
        rmiRegistryFactoryBean.setPort(1099);
        return rmiRegistryFactoryBean;
    }

    /**
     * 远程访问基于RMI的远程服务器
     * @return
     */
    @Bean
    public MBeanServerConnectionFactoryBean connectionFactoryBean() {
        MBeanServerConnectionFactoryBean mbscfb = new MBeanServerConnectionFactoryBean();
        try {
            mbscfb.setServiceUrl("service:jmx:rmi://localhost/jndi/rmi://localhost:1099/mbean");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return mbscfb;
    }

    /**
     * 远程访问RMI
     * @param connection
     * @return
     */
    @Bean
    public MBeanServerConnection jmxClient(MBeanServerConnection connection) {
        try {
            int mbeanCount = connection.getMBeanCount();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 代理MBean远程访问MBean
     * @param connection
     * @return
     */
    @Bean
    public MBeanProxyFactoryBean beanProxyFactoryBean(MBeanServerConnection connection) {
        MBeanProxyFactoryBean proxy = new MBeanProxyFactoryBean();
        try {
            proxy.setObjectName("");
            proxy.setServer(connection);
            proxy.setProxyInterface(ControllerManageOperation.class);
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
        return proxy;
    }


}
