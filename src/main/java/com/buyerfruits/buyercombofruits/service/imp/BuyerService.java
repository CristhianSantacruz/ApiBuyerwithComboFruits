package com.buyerfruits.buyercombofruits.service.imp;

import com.buyerfruits.buyercombofruits.models.BuyerEntity;
import com.buyerfruits.buyercombofruits.repository.BuyerRepository;
import com.buyerfruits.buyercombofruits.service.IBuyerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService implements IBuyerService {

    private final BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository buyerRepository){
        this.buyerRepository = buyerRepository;
    }

    @Override
    public List<BuyerEntity> findAll() {
        return buyerRepository.findAll();
    }

    @Override
    public Optional<BuyerEntity> findById(Long id) {
        return buyerRepository.findById(id);
    }

    @Override
    public List<BuyerEntity> findByIdCombo(Long id) {
        return buyerRepository.findByCombo(id);
    }

    @Override
    public void save(BuyerEntity buyerEntity) {
         buyerRepository.save(buyerEntity);
    }
}
