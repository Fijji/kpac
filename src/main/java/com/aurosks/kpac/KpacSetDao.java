package com.aurosks.kpac;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class KpacSetDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<KpacSet> getAllKpacSets() {
        String sql = "SELECT * FROM kpac_sets";
        return jdbcTemplate.query(sql, new RowMapper<KpacSet>() {
            public KpacSet mapRow(ResultSet rs, int rowNum) throws SQLException {
                KpacSet kpacSet = new KpacSet();
                kpacSet.setId(rs.getLong("id"));
                kpacSet.setTitle(rs.getString("title"));
                return kpacSet;
            }
        });
    }

    public void addKpacSet(KpacSet kpacSet) {
        String sql = "INSERT INTO kpac_sets (title) VALUES (?)";
        jdbcTemplate.update(sql, kpacSet.getTitle());
    }

    public void deleteKpacSet(Long id) {
        String sql = "DELETE FROM kpac_sets WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void updateKpacSet(KpacSet kpacSet) {
        String sql = "UPDATE kpac_sets SET title = ? WHERE id = ?";
        jdbcTemplate.update(sql, kpacSet.getTitle(), kpacSet.getId());
    }

    public KpacSet getKpacSetById(Long id) {
        String sql = "SELECT * FROM kpac_sets WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            KpacSet kpacSet = new KpacSet();
            kpacSet.setId(rs.getLong("id"));
            kpacSet.setTitle(rs.getString("title"));
            return kpacSet;
        });
    }
}

