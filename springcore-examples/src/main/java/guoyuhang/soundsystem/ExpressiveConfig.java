package guoyuhang.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource("classpath:/top/guoyuhang/soundsystem/db.properties")
public class ExpressiveConfig {

    @Autowired
    Environment env;
//
//    @Bean
//    public BlankDisc disc() {
//        env.getRequiredProperty("");
//        env.containsProperty("");
//        env.getActiveProfiles();
//        env.getDefaultProfiles();
//
//        return new BlankDisc(env.getProperty("title", "default"), env.getProperty("title", "default"));
//    }
}
