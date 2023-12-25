package com.buyerfruits.buyercombofruits.models.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class BuyerDto {

    private String name;
    private String dni;
    private String email;
}
