package com.bootcamp.fruitbox.controller;

import com.bootcamp.fruitbox.dto.FruitDto;
import com.bootcamp.fruitbox.service.FruitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/fruits")
public class ApiController {

    private FruitService fruitService;

    @PostMapping("create")
    public ResponseEntity<FruitDto> create(@RequestBody FruitDto fruitDto){
        FruitDto savedData = fruitService.create(fruitDto);
        return new ResponseEntity<>(savedData, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<FruitDto> getById(@PathVariable("id") Long fruitId){
        FruitDto fruitDto = fruitService.getById(fruitId);
        return ResponseEntity.ok(fruitDto);
    }

    @GetMapping("get")
    public ResponseEntity<List<FruitDto>> getAll(){
        List<FruitDto> fruits = fruitService.getAll();
        return ResponseEntity.ok(fruits);
    }

    @PutMapping("{id}")
    public ResponseEntity<FruitDto> update(@PathVariable("id") Long id, @RequestBody FruitDto newFruitDto){
        FruitDto fruitDto = fruitService.update(id, newFruitDto);
        return ResponseEntity.ok(fruitDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<FruitDto> delete(@PathVariable("id") Long id){
        fruitService.softDelete(id);
        return ResponseEntity.noContent().build();
    }

}
