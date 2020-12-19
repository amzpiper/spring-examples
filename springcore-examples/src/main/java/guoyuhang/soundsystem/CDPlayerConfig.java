package guoyuhang.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
//@ComponentScan
//@ComponentScan(basePackages = "top.guoyuhang")
//@ComponentScan(basePackageClasses = {CDPlayer.class})
@Import(CDConfig.class)
//@ImportResource("classpath:applicationContext.xml")
@Profile("dev")
public class CDPlayerConfig {

    @Bean
    @Profile("dev")
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc cd) {
//    public CDPlayer cdPlayer() {
        return new CDPlayer(cd);
//        return new CDPlayer(sgtPeppers());
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
