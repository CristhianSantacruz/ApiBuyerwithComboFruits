package com.buyerfruits.buyercombofruits.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter

@Entity
@Table(name = "tb_fruit")
public class FruitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name= "id_buyer",nullable = false)
    private ComboEntity combo;
}
