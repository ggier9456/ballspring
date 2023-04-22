package com.example.ballspring.dao;

import com.example.ballspring.model.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getPitem(String bType);
}
