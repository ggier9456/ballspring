package com.example.ballspring.service.impl;

import com.example.ballspring.dao.SearchDao;
import com.example.ballspring.model.Search;
import com.example.ballspring.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchDao searchDao;
    @Override
    public List<Search> search(String searchName) {
        return searchDao.search(searchName);
    }
}
