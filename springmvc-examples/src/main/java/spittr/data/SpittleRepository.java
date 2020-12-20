package spittr.data;

import spittr.model.Spitter;
import spittr.model.Spittle;

import java.util.List;

public interface SpittleRepository {

    public List<Spittle> findSpittles(long max, int count);
    public Spitter findOne(long spittleId);

    void save(Spitter spitter);

    Spitter findByUsername(String username);
}
