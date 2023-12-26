package com.buyerfruits.buyercombofruits.models.dto;

import com.buyerfruits.buyercombofruits.models.ComboEntity;
import lombok.*;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class FruitDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private ComboEntity combo;
}
