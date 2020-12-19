package top.guoyuhang.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
//@ComponentScan(basePackages = "top.guoyuhang")
//@ComponentScan(basePackageClasses = {CDPlayer.class})
public class CDPlayerConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc cd) {
//    public CDPlayer cdPlayer() {
        return new CDPlayer(cd);
//        return new CDPlayer(sgtPeppers());
    }

}
