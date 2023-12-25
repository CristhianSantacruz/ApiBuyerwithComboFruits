package com.buyerfruits.buyercombofruits.repository;

import com.buyerfruits.buyercombofruits.models.FruitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FruitRepository extends JpaRepository<FruitEntity,Long> {

}
