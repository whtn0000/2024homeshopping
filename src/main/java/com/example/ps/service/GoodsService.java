package com.example.ps.service;

import com.example.ps.domain.Goods;
import com.example.ps.domain.User;
import com.example.ps.entity.GoodsEntity;

import java.util.List;

public interface GoodsService {
    List<GoodsEntity> getGoods();
    Goods createGoods(Goods goods);
}
