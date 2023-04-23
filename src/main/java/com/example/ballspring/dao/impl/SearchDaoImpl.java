package com.example.ballspring.dao.impl;

import com.example.ballspring.dao.SearchDao;
import com.example.ballspring.mapper.SearchRowMapper;
import com.example.ballspring.model.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SearchDaoImpl implements SearchDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Search> search(String searchName) {
        String sql = "CALL search(:searchname)";
        Map<String, String> map = new HashMap<>();
        map.put("searchname", searchName);
        List<Search> list = namedParameterJdbcTemplate.query(sql, map, new SearchRowMapper());
        if (list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
