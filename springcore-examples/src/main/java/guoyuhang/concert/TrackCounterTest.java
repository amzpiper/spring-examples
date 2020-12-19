package guoyuhang.concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import guoyuhang.soundsystem.CompactDisc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TrackCounterTest {

    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    private TrackCounter counter;

    @Test
    public void test() {
        compactDisc.playTrack(1);
        compactDisc.playTrack(2);
        compactDisc.playTrack(3);

        System.out.println(counter.getPlayCount(1));
    }
}
