package com.buyerfruits.buyercombofruits.controllers;


import com.buyerfruits.buyercombofruits.models.BuyerEntity;
import com.buyerfruits.buyercombofruits.service.IBuyerService;
import com.buyerfruits.buyercombofruits.service.imp.BuyerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/buyer")
public class BuyerController {

    private final IBuyerService buyerService;

    public BuyerController(IBuyerService buyerService){
        this.buyerService= buyerService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> findByAll(){
        return ResponseEntity.status(HttpStatus.OK).body(buyerService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable(name="id") Long id){
        Optional<BuyerEntity> buyerEntity = buyerService.findById(id);
        if(buyerEntity.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Buyer not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(buyerEntity.get());
    }
    @PostMapping("/save")
    public void save(@RequestBody BuyerEntity buyerEntity){

        buyerService.save(buyerEntity);
    }
}
