package top.guoyuhang.spitter;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpitterServiceImpl implements SpitterService{
    @Override
    public List<Spitter> getRecentSpitters() {
        return null;
    }

    @Override
    public void saveSpitter(Spitter spitter) {

    }

    @Override
    public Spitter getSpitter(long id) {
        return null;
    }
}
