package com.example.ps.domain;

import com.example.ps.entity.GoodsEntity;
import com.example.ps.entity.UserEntity;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Goods {
    private int goodsId;
    private String name;
    private String price;

    public static GoodsEntity toEntity(Goods user) {
        return GoodsEntity.builder()
                .name(user.getName())
                .goodsId(user.getGoodsId())
                .price(user.getPrice())
                .build();
    }

    public static Goods toDomain(GoodsEntity entity) {
        return Goods.builder()
                .goodsId(entity.getGoodsId())
                .name(entity.getName())
                .goodsId(entity.getGoodsId())
                .build();
    }
}
