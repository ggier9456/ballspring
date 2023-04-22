package com.example.ballspring.mapper;

import com.example.ballspring.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setEmail(rs.getString("mEmail"));
        user.setUsername(rs.getString("mUsername"));
        return user;
    }
}
