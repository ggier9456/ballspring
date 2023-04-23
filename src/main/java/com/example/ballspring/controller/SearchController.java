package com.example.ballspring.controller;


import com.example.ballspring.model.Search;
import com.example.ballspring.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;
    @GetMapping("/search")
    public String search(@RequestParam(name="search_name") String searchName,
                         Model model){
        List<Search> list = searchService.search(searchName);
        model.addAttribute("searchList", list);
        return "/search/search";
    }
}
