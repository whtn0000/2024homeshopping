package com.example.ps.serviceImpl;

import com.example.ps.domain.Goods;
import com.example.ps.entity.GoodsEntity;
import com.example.ps.repository.GoodsRepository;
import com.example.ps.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodsSerivceImpl implements GoodsService {
    private final GoodsRepository goodsRepository;
    @Override
    public List<GoodsEntity> getGoods() {
        List<GoodsEntity> goodsEntitys = goodsRepository.findAll();
        return goodsEntitys;
    }

    @Override
    public Goods createGoods(Goods goods) {
        GoodsEntity goodsEntity = Goods.toEntity(goods);
        goodsRepository.save(goodsEntity);
        return goods;
    }
}
