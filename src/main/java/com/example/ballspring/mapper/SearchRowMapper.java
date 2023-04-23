package com.example.ballspring.mapper;

import com.example.ballspring.model.Search;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchRowMapper implements RowMapper<Search> {
    @Override
    public Search mapRow(ResultSet rs, int rowNum) throws SQLException {
        Search search = new Search();
        search.setpName(rs.getString("pName"));
        search.setpImg(rs.getString("pImg"));
        search.setpLink(rs.getString("pLink"));
        return search;
    }
}
