package com.example.ballspring.controller;


import com.example.ballspring.dao.BallType;
import com.example.ballspring.model.Product;
import com.example.ballspring.model.PurchasePage;
import com.example.ballspring.service.ProductService;
import com.example.ballspring.service.PurchasePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/commodity")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private PurchasePageService purchasePageService;

    @GetMapping("/{bType}")
    public String product(@PathVariable String bType, Model model){
        Product product =new Product();
        List<Product> list=productService.getPitem(bType);
        product=list.get(0);
        model.addAttribute("pList", list);
        model.addAttribute("bTitle", product.getbTitle());
        model.addAttribute("bIcon", product.getbIcon());
        return "/goods/goods";
    }
    @GetMapping("/{bType}/{bId}")
    public String purchasePage(@PathVariable Integer bId,
                               @PathVariable String bType, Model model){

        BallType ballType =new BallType();
        ballType.setbId(bId);
        ballType.setbType(bType);
        List<PurchasePage> list = purchasePageService.getPpage(ballType);
        model.addAttribute("pList", list.get(0));
        return "/goods/purchase";
    }


}

