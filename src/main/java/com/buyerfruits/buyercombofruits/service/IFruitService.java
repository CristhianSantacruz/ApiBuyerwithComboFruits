package com.buyerfruits.buyercombofruits.service;

import com.buyerfruits.buyercombofruits.models.ComboEntity;
import com.buyerfruits.buyercombofruits.models.FruitEntity;

import java.util.List;
import java.util.Optional;

public interface IFruitService {


    List<FruitEntity> findAll();

    Optional<FruitEntity> findById(Long id);


    void save(FruitEntity comboEntity);
}
