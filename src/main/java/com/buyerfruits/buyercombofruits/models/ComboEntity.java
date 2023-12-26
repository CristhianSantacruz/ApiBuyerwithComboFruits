package com.buyerfruits.buyercombofruits.models;

import com.fasterxml.jackson.annotation.*;
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
@Builder
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
    @JsonManagedReference
    private List<FruitEntity> fruits = new ArrayList<>();

    @ManyToMany(mappedBy = "comboEntities", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private List<BuyerEntity> buyerEntityList = new ArrayList<>();


}
