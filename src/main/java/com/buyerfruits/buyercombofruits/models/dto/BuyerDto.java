package com.buyerfruits.buyercombofruits.models.dto;


import com.buyerfruits.buyercombofruits.models.ComboEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class BuyerDto {

    private Long id;
    private String name;
    private String dni;
    private String email;
    private List<ComboEntity> comboEntities = new ArrayList<>();
}
