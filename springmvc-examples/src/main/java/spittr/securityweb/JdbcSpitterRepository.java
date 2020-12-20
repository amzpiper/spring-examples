package spittr.securityweb;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Repository;
import spittr.data.SpitterRowMapper;
import spittr.data.SpittleRepository;
import spittr.model.Spitter;
import spittr.model.Spittle;

import javax.annotation.security.RolesAllowed;
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

    @Override
    public void save(Spitter spitter) {

    }

    @Override
    public Spitter findByUsername(String username) {
        return null;
    }

    @RolesAllowed("ROLE_SPITTER")
    public void addS(Spittle spittle) {
        jdbcOperations.update("", spittle.getLatitude());
        jdbcOperations.queryForObject("", SpitterRowMapper.class);
    }

    @PreAuthorize("hasRole('ROLE_SPITTER') and #spittleId >= 10")
    @PostAuthorize("hasRole('') || returnObject.firstName == principal.username")
    @PreFilter("hasRole('') || filterObject.username == principal.username")
    @Override
    public Spitter findOne(long spittleId) {
//        return (Spitter) jdbcOperations.queryForObject("", new SpitterRowMapper(), id);
        return jdbcOperations.queryForObject("", (rs,rowNum)->{
            return new Spitter(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString(""),
                    rs.getString(""),
                    rs.getString("")
            );
        }, spittleId);
    }

    @Secured({"ROLE_SPITTER",""})
    public void addP(Spitter spitter) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("", spitter.getId());
        jdbcOperations.update("insert in Spitter(id) values (:id)", paramMap);
    }

    @PostFilter("hasRole('') || filterObject.spittle.username == principal.username")
    public void deleteSpittles(List<Spittle> spittles){

    }
}
