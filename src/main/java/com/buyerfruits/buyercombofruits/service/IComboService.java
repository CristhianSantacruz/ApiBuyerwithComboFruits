package com.buyerfruits.buyercombofruits.service;

import com.buyerfruits.buyercombofruits.models.BuyerEntity;
import com.buyerfruits.buyercombofruits.models.ComboEntity;

import java.util.List;
import java.util.Optional;

public interface IComboService {

    List<ComboEntity> findAll();

    Optional<ComboEntity> findById(Long id);


    void save(ComboEntity comboEntity);

}
