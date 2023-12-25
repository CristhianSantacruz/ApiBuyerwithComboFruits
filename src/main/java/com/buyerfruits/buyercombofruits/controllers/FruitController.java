package com.buyerfruits.buyercombofruits.controllers;

import com.buyerfruits.buyercombofruits.models.ComboEntity;
import com.buyerfruits.buyercombofruits.models.FruitEntity;
import com.buyerfruits.buyercombofruits.service.imp.FruitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/fruit")
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService){
        this.fruitService = fruitService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> findByAll(){
        return ResponseEntity.status(HttpStatus.OK).body(fruitService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<FruitEntity> comboEntity = fruitService.findById(id);
        if(comboEntity.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fruit not fount");

        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(fruitService.findById(id));
        }
    }

    @PostMapping("/save")
    public void save(@RequestBody FruitEntity fruitEntity){
        fruitService.save(fruitEntity);
    }
}
