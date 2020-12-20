package top.guoyuhang.rmi.spitter;

import java.util.List;

public interface SpitterService {

    List<Spitter> getRecentSpitters();

    void saveSpitter(Spitter spitter);

    Spitter getSpitter(long id);
}
