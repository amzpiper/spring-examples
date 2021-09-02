package spitter.api;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configurable
@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 默认返回HTML格式数据
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.TEXT_HTML);
    }

    /**
     * 生成contentNegotiationBean
     * @param contentNegotiationManager
     * @return
     */
    @Bean
    public ViewResolver cnViewResolver(ContentNegotiationManager contentNegotiationManager) {
        ContentNegotiatingViewResolver vm = new ContentNegotiatingViewResolver();
        vm.setContentNegotiationManager(contentNegotiationManager);
        return vm;
    }

    /**
     * 以bean方式查找试图
     * @return
     */
    @Bean
    public ViewResolver beanNameViewResolver() {
        return new BeanNameViewResolver();
    }

    @Bean
    public View spittle() {
        return new MappingJackson2JsonView();
    }
}
