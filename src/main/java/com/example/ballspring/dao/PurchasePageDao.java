package com.example.ballspring.dao;

import com.example.ballspring.model.BallType;
import com.example.ballspring.model.PurchasePage;

import java.util.List;

public interface PurchasePageDao {
    List<PurchasePage> getPpage(BallType ballType);
}
