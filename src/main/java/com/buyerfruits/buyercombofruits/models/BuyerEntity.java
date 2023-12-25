package com.buyerfruits.buyercombofruits.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.boot.model.source.spi.FetchCharacteristics;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter

@Entity
@Table(name="tb_buyer")
public class BuyerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dni;
    private String email;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name= "buyer_combo",joinColumns = @JoinColumn(name="buyer_id"),
    inverseJoinColumns = @JoinColumn(name ="combo_id"))
    @JsonManagedReference
    private List<ComboEntity> comboEntities = new ArrayList<>();




}
