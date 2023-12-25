package com.buyerfruits.buyercombofruits.service;

import com.buyerfruits.buyercombofruits.models.BuyerEntity;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface IBuyerService {

    List<BuyerEntity> findAll();

    Optional<BuyerEntity> findById(Long id);

    List<BuyerEntity> findByIdCombo(Long id);

    void save(BuyerEntity buyerEntity);


}
