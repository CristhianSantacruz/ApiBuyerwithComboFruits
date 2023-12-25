package com.buyerfruits.buyercombofruits.controllers;


import com.buyerfruits.buyercombofruits.models.BuyerEntity;
import com.buyerfruits.buyercombofruits.models.ComboEntity;
import com.buyerfruits.buyercombofruits.models.dto.ComboDto;
import com.buyerfruits.buyercombofruits.service.imp.ComboService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/combo")
public class ComboController {

    private final ComboService comboService;

    public ComboController(ComboService comboService){
        this.comboService = comboService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> findByAll(){
        List<ComboDto> comboDtoList = comboService.findAll()
                .stream()
                .map(combo -> ComboDto.builder()
                        .name(combo.getName())
                        .id(combo.getId())
                        .price(combo.getPrice())
                        .fruits(combo.getFruits())
                        .buyerEntityList(combo.getBuyerEntityList()).build()).toList();
                
        return ResponseEntity.status(HttpStatus.OK).body(comboDtoList);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable  Long id){
        Optional<ComboEntity> comboEntity = comboService.findById(id);
        if(comboEntity.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Combo not fount");
        }
        else{
            ComboDto comboDto = ComboDto.builder()
                    .id(comboEntity.get().getId())
                    .name(comboEntity.get().getName())
                    .price(comboEntity.get().getPrice())
                    .fruits(comboEntity.get().getFruits())
                    .buyerEntityList(comboEntity.get().getBuyerEntityList()).build();
            
            return ResponseEntity.status(HttpStatus.OK).body(comboDto);
        }
    }

    @PostMapping("/save")
    public void save(@RequestBody ComboDto comboDto){

        comboService.save(ComboEntity.builder()
                .name(comboDto.getName())
                .price(comboDto.getPrice())
                .build());

    }

}
