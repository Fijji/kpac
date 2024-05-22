package com.aurosks.kpac;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class KpacDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Kpac> getAllKpacs() {
        String sql = "SELECT * FROM kpacs";
        return jdbcTemplate.query(sql, new RowMapper<Kpac>() {
            public Kpac mapRow(ResultSet rs, int rowNum) throws SQLException {
                Kpac kpac = new Kpac();
                kpac.setId(rs.getLong("id"));
                kpac.setTitle(rs.getString("title"));
                kpac.setDescription(rs.getString("description"));
                kpac.setCreationDate(rs.getString("creation_date"));
                return kpac;
            }
        });
    }

    public void addKpac(Kpac kpac) {
        String sql = "INSERT INTO kpacs (title, description, creation_date) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, kpac.getTitle(), kpac.getDescription(), kpac.getCreationDate());
    }

    public void deleteKpac(Long id) {
        String sql = "DELETE FROM kpacs WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void updateKpac(Kpac kpac) {
        String sql = "UPDATE kpacs SET title = ?, description = ?, creation_date = ? WHERE id = ?";
        jdbcTemplate.update(sql, kpac.getTitle(), kpac.getDescription(), kpac.getCreationDate(), kpac.getId());
    }

    public Kpac getKpacById(Long id) {
        String sql = "SELECT * FROM kpacs WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Kpac kpac = new Kpac();
            kpac.setId(rs.getLong("id"));
            kpac.setTitle(rs.getString("title"));
            kpac.setDescription(rs.getString("description"));
            kpac.setCreationDate(String.valueOf(rs.getDate("creation_date")));
            return kpac;
        });
    }
}
