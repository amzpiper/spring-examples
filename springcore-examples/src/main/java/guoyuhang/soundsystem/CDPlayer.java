package guoyuhang.soundsystem;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * CD播放器
 */
@Component
@Primary
@Code
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CDPlayer implements MediaPlayer{

    private CompactDisc cd;

    @Inject
    public CDPlayer(@Named("sgtPeppers") CompactDisc cd) {
        this.cd = cd;
    }

    public CDPlayer() {

    }

    public void play() {
        cd.play();
    }

    public CompactDisc getCd() {
        return cd;
    }

    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }
}
