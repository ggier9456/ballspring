package com.example.ballspring.dao.impl;

import com.example.ballspring.dao.ProductDao;
import com.example.ballspring.mapper.ProductRowMapper;
import com.example.ballspring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public List<Product> getPitem(String bType) {
        String sql ="CALL get_product(:bType);";
        Map<String, String> map = new HashMap<>();
        map.put("bType", bType);
        List<Product> list =namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        if(list.size() >0){
            return list;
        }else{
            return null;
        }
    }
}
