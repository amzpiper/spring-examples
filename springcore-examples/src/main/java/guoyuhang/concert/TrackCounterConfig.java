package guoyuhang.concert;

import guoyuhang.soundsystem.BlankDisc;
import guoyuhang.soundsystem.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan( basePackages = "guoyuhang")
public class TrackCounterConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        BlankDisc cd = new BlankDisc();
        cd.setTitle("blank");
        cd.setArtist("Artist");
        List<String> tracks = new ArrayList<>();
        tracks.add("cd1");
        tracks.add("cd2");
        tracks.add("cd3");
        tracks.add("cd4");
        cd.setTracks(tracks);
        return cd;
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }
}
