package com.example.ps.repository;

import com.example.ps.entity.GoodsEntity;
import com.example.ps.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoodsRepository extends JpaRepository<GoodsEntity, Integer> {

}
