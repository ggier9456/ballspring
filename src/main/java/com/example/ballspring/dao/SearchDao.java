package com.example.ballspring.dao;

import com.example.ballspring.model.Search;

import java.util.List;

public interface SearchDao {
    List<Search> search(String searchName);
}
