package com.buyerfruits.buyercombofruits.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter

@Entity
@Table(name="tb_combos")
public class ComboEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;

    @OneToMany(mappedBy = "combo",
               cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,orphanRemoval = true)
    private List<FruitEntity> fruits = new ArrayList<>();

    @ManyToMany(mappedBy = "comboEntities", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<BuyerEntity> buyerEntityList = new ArrayList<>();


}
