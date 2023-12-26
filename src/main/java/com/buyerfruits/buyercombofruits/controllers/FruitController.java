package com.buyerfruits.buyercombofruits.controllers;
import com.buyerfruits.buyercombofruits.models.FruitEntity;
import com.buyerfruits.buyercombofruits.models.dto.FruitDto;
import com.buyerfruits.buyercombofruits.service.imp.FruitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
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

        List<FruitDto> fruitDtoList = fruitService.findAll()
                .stream()
                .map(fruit -> FruitDto.builder()
                        .name(fruit.getName())
                        .id(fruit.getId())
                        .price(fruit.getPrice())
                        .combo(fruit.getCombo()).build()).toList();


        return ResponseEntity.status(HttpStatus.OK).body(fruitDtoList);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<FruitEntity> comboEntity = fruitService.findById(id);
        if(comboEntity.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fruit not fount");

        }
        else{
            FruitDto fruitDto = FruitDto.builder()
                    .id(comboEntity.get().getId())
                    .name(comboEntity.get().getName())
                    .combo(comboEntity.get().getCombo())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(fruitDto);
        }
    }

    @PostMapping("/save")
    public void save(@RequestBody FruitDto fruitDto){

        FruitEntity fruitEntity = FruitEntity.builder()
                        .name(fruitDto.getName())
                                .price(fruitDto.getPrice())
                                        .combo(fruitDto.getCombo()).build();

        fruitService.save(fruitEntity);
    }
}
