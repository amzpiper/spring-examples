package spittr.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import spittr.data.SpitterRowMapper;
import spittr.data.SpittleRepository;
import spittr.model.Spitter;
import spittr.model.Spittle;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcSpitterRepository implements SpittleRepository {

    private JdbcOperations jdbcOperations;

    @Inject
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    @CachePut(value = "spitter",key = "#root.id",unless = "@result.message.contains('NoCache')")
    @Override
    public void save(Spitter spitter) {

    }

    @Override
    public Spitter findByUsername(String username) {
        return null;
    }

    public void addS(Spittle spittle) {
        jdbcOperations.update("", spittle.getLatitude());
        jdbcOperations.queryForObject("", SpitterRowMapper.class);
    }

    @CachePut(value = "spittleCache")
    @Cacheable(value = "spittleCache",condition = "#id >= 10")
    @Override
    public Spitter findOne(long spittleId) {
//        return (Spitter) jdbcOperations.queryForObject("", new SpitterRowMapper(), id);
        return jdbcOperations.queryForObject("", (rs, rowNum) -> {
            return new Spitter(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString(""),
                    rs.getString(""),
                    rs.getString("")
            );
        }, spittleId);
    }

    @CacheEvict("")
    public void remove(long id){

    }

    public void addP(Spitter spitter) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("", spitter.getId());
        jdbcOperations.update("insert in Spitter(id) values (:id)", paramMap);
    }
}
