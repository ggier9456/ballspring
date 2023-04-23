package com.example.ballspring.service;

import com.example.ballspring.dao.BallType;
import com.example.ballspring.model.PurchasePage;

import java.util.List;

public interface PurchasePageService {
    List<PurchasePage> getPpage(BallType ballType);
}
