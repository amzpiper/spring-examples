package top.guoyuhang.spitter;

import java.util.List;

public interface SpitterService {

    List<Spitter> getRecentSpitters();

    void saveSpitter(Spitter spitter);

    Spitter getSpitter(long id);
}
