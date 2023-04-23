package com.example.ballspring.service;

import com.example.ballspring.model.Search;

import java.util.List;

public interface SearchService {
    List<Search> search(String searchName);
}
