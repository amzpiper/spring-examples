package top.guoyuhang.soundsystem;

import jdk.jfr.Name;
import org.springframework.stereotype.Component;

@Component
//@Component("lonelyHeartsClub")
//@Name("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper";
    private String artist = "The BEATLES";

    @Override
    public void play() {
        System.out.println("Playing " + title + "by" + artist);
    }
}
