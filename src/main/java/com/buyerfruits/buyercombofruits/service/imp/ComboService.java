package com.buyerfruits.buyercombofruits.service.imp;

import com.buyerfruits.buyercombofruits.models.ComboEntity;
import com.buyerfruits.buyercombofruits.repository.ComboRepository;
import com.buyerfruits.buyercombofruits.service.IComboService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ComboService implements IComboService {

    private final ComboRepository comboRepository;
    public ComboService(ComboRepository comboRepository){
        this.comboRepository = comboRepository;
    }
    @Override
    public List<ComboEntity> findAll() {
        return comboRepository.findAll();
    }

    @Override
    public Optional<ComboEntity> findById(Long id) {
        return comboRepository.findById(id);
    }

    @Override
    public void save(ComboEntity comboEntity) {
        comboRepository.save(comboEntity);
    }
}
