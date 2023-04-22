package com.example.ballspring.service.impl;

import com.example.ballspring.dao.ProductDao;
import com.example.ballspring.model.Product;
import com.example.ballspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getPitem(String bType) {
        return productDao.getPitem(bType);
    }
}
