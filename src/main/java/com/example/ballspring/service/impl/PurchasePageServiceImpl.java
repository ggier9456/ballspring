package com.example.ballspring.service.impl;

import com.example.ballspring.dao.PurchasePageDao;
import com.example.ballspring.model.BallType;
import com.example.ballspring.model.PurchasePage;
import com.example.ballspring.service.PurchasePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PurchasePageServiceImpl implements PurchasePageService {

    @Autowired
    private PurchasePageDao purchasePageDao;

    @Override
    public List<PurchasePage> getPpage(BallType ballType) {
        return purchasePageDao.getPpage(ballType);
    }
}
