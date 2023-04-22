package com.example.ballspring.mapper;

import com.example.ballspring.model.PurchasePage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchasePageRowMapper implements RowMapper<PurchasePage> {
    @Override
    public PurchasePage mapRow(ResultSet rs, int rowNum) throws SQLException {
        PurchasePage purchasePage = new PurchasePage();
        purchasePage.setpId(rs.getInt("pId"));
        purchasePage.setpName(rs.getString("pName"));
        purchasePage.setpImg(rs.getString("pImg"));
        purchasePage.setpDescription(rs.getString("pDescription"));
        purchasePage.setpPrice(rs.getInt("pPrice"));
        return purchasePage;
    }
}
