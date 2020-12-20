package spittr.data;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.util.Properties;

@Configuration
@ComponentScan
public class DataConfig {

    @Profile("test")
    @Bean
    public JndiObjectFactoryBean dataSource() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("/jdbc");
        jndiObjectFactoryBean.setResourceRef(true);
//        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource);
        return jndiObjectFactoryBean;
    }

    @Profile("dev")
    @Bean
    public DataSource dataSource2() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("");
        ds.setUsername("");
        ds.setPassword("");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource) {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource);
//        sfb.setMappingResources(new String[]{"sss.hbm.xml"});
        sfb.setPackagesToScan(new String[]{"spitter"});
        Properties props = new Properties();
        props.setProperty("", "");
        sfb.setHibernateProperties(props);
        return sfb;
    }

    /**
     * 给repository注解类添加通知，拦截异常，转换为非检测型数据库异常
     * @return
     */
    @Bean
    public BeanPostProcessor pe() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
//    @Bean
//    public AnnotationSessionFactoryBean sessionFactoryBean(DataSource dataSource) {
//        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
//        sfb.setDataSource(dataSource);
//        sfb.setMappingResources(new String[]{"sss.hbm.xml"});
//        Properties props = new Properties();
//        props.setProperty("", "");
//        sfb.setHibernateProperties(props);
//        return sfb;
//    }

}