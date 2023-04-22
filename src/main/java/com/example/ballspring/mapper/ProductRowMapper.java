package com.example.ballspring.mapper;


import com.example.ballspring.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product =new Product();
        product.setpName(rs.getString("pName"));
        product.setpImg(rs.getString("pImg"));
        product.setpLink(rs.getString("pLink"));
        product.setpPrice(rs.getInt("pPrice"));
        product.setbTitle(rs.getString("bTitle"));
        product.setbIcon(rs.getString("bIcon"));
        return product;
    }
}
