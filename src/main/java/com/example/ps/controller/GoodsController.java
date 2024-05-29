package com.example.ps.controller;


import com.example.ps.domain.Goods;
import com.example.ps.entity.GoodsEntity;
import com.example.ps.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsService goodsService;

    @PostMapping
    Goods createGoods(@RequestBody Goods goods){
        return goodsService.createGoods(goods);
    }

    @GetMapping
    List<GoodsEntity> getGoods(){
        return goodsService.getGoods();
    }
}
