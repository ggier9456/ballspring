package com.example.ballspring.dao.impl;

import com.example.ballspring.dao.PurchasePageDao;
import com.example.ballspring.mapper.PurchasePageRowMapper;
import com.example.ballspring.dao.BallType;
import com.example.ballspring.model.PurchasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PurchasePageDaoImpl implements PurchasePageDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<PurchasePage> getPpage(BallType ballType) {
        String sql= "CALL get_purchase_page(:bType, :bId)";
        Map<String, Object> map = new HashMap<>();
        map.put("bType", ballType.getbType());
        map.put("bId", ballType.getbId());
        List<PurchasePage> list = namedParameterJdbcTemplate.query(sql, map, new PurchasePageRowMapper());
        if(list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
