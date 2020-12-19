package top.guoyuhang.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

/**
 * CD播放器
 */
@Component
public class CDPlayer implements MediaPlayer{

    private CompactDisc cd;

    @Inject
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public CDPlayer() {

    }

    public void play() {
        cd.play();
    }

}
