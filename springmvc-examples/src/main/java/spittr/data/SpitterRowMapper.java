package spittr.data;

import org.springframework.jdbc.core.RowMapper;
import spittr.model.Spitter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpitterRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Spitter(
                resultSet.getLong("id"),
                resultSet.getString("username"),
                resultSet.getString(""),
                resultSet.getString(""),
                resultSet.getString("")
        );
    }
}
