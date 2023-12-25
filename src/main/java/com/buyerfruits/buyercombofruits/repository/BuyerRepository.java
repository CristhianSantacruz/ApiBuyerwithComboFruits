package com.buyerfruits.buyercombofruits.repository;

import com.buyerfruits.buyercombofruits.models.BuyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BuyerRepository extends JpaRepository<BuyerEntity,Long> {

    @Query("select b from BuyerEntity b join b.comboEntities c where c = ?1 ")
    List<BuyerEntity> findByCombo(Long id);
}
