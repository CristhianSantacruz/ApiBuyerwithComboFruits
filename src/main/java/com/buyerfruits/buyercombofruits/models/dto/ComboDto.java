package com.buyerfruits.buyercombofruits.models.dto;

import com.buyerfruits.buyercombofruits.models.BuyerEntity;
import com.buyerfruits.buyercombofruits.models.FruitEntity;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ComboDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private List<FruitEntity> fruits = new ArrayList<>();
    private List<BuyerEntity> buyerEntityList = new ArrayList<>();

}
