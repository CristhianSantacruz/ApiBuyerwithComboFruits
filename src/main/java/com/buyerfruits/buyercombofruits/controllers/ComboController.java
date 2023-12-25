package com.buyerfruits.buyercombofruits.controllers;


import com.buyerfruits.buyercombofruits.models.ComboEntity;
import com.buyerfruits.buyercombofruits.service.imp.ComboService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.status(HttpStatus.OK).body(comboService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable  Long id){
        Optional<ComboEntity> comboEntity = comboService.findById(id);
        if(comboEntity.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Combo not fount");

        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(comboService.findById(id));
        }
    }

    @PostMapping("/save")
    public void save(@RequestBody ComboEntity comboEntity){
         comboService.save(comboEntity);
    }

}
