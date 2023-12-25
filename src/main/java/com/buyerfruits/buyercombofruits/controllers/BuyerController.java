package com.buyerfruits.buyercombofruits.controllers;


import com.buyerfruits.buyercombofruits.models.BuyerEntity;
import com.buyerfruits.buyercombofruits.models.dto.BuyerDto;
import com.buyerfruits.buyercombofruits.service.IBuyerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/buyer")
public class BuyerController {

    private final IBuyerService buyerService;

    public BuyerController(IBuyerService buyerService){
        this.buyerService= buyerService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> findByAll(){

        List<BuyerDto> buyerDtoList = buyerService.findAll()
                .stream()
                .map(buyer-> BuyerDto.builder()
                        .name(buyer.getName())
                        .id(buyer.getId())
                        .email(buyer.getEmail())
                        .dni(buyer.getDni())
                        .comboEntities(buyer.getComboEntities())
                        .build()).toList();
        return ResponseEntity.ok(buyerDtoList);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name="id") Long id){
        Optional<BuyerEntity> buyerEntity = buyerService.findById(id);
        if(buyerEntity.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Buyer not found");
        }
        BuyerEntity buyer = buyerEntity.get();
        BuyerDto buyerDto = BuyerDto.builder()
                .id(buyer.getId())
                .name(buyer.getName())
                .email(buyer.getEmail())
                .dni(buyer.getDni())
                .comboEntities(buyer.getComboEntities()).build();


        return ResponseEntity.status(HttpStatus.OK).body(buyerDto);
    }
    @PostMapping("/save")
    public void save(@RequestBody BuyerDto buyerDto){

        buyerService.save(BuyerEntity.builder()
                .name(buyerDto.getName())
                .dni(buyerDto.getDni())
                .email(buyerDto.getEmail()).build()
        );
    }
}
