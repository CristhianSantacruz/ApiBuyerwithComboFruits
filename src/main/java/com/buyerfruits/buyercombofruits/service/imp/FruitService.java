package com.buyerfruits.buyercombofruits.service.imp;

import com.buyerfruits.buyercombofruits.models.FruitEntity;
import com.buyerfruits.buyercombofruits.repository.FruitRepository;
import com.buyerfruits.buyercombofruits.service.IFruitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FruitService  implements IFruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository){
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<FruitEntity> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Optional<FruitEntity> findById(Long id) {
        return fruitRepository.findById(id);
    }

    @Override
    public void save(FruitEntity fruitEntity) {
        fruitRepository.save(fruitEntity);
    }
}
