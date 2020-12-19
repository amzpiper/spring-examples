package guoyuhang.soundsystem;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@Component("lonelyHeartsClub")
//@Name("lonelyHeartsClub")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper";
    private String artist = "The BEATLES";
    private List<String> tracks;

    @Override
    public void play() {
        System.out.println("Playing " + title + "by" + artist);
    }

    @Override
    public void playTrack(int number) {
        System.out.println(number + ":" + tracks.get(number));
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }
}
