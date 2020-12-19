package guoyuhang.soundsystem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlankDisc implements CompactDisc {
    private String title = "BlankDisc";
    private String artist = "The BlankDisc";
    private List<String> tracks;
    private List<CompactDisc> cd;

    public BlankDisc() {

    }

    public BlankDisc(@Value("#{systemProperties['title']}") String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
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

    public BlankDisc(List<CompactDisc> cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        System.out.println("Playing " + title + "by" + artist);
    }

    @Override
    public void playTrack(int number) {
        System.out.println(number + ":" + tracks.get(number));
    }
}
