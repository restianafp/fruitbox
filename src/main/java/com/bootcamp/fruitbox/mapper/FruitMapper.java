package com.bootcamp.fruitbox.mapper;

import com.bootcamp.fruitbox.dto.FruitDto;
import com.bootcamp.fruitbox.entity.Fruit;

public class FruitMapper {
    public static FruitDto mapToFruitDto(Fruit fruit){
        return new FruitDto(
                fruit.getId(),
                fruit.getName(),
                fruit.getLatinName(),
                fruit.getDesc(),
                fruit.getCalories()
        );
    }

    public static Fruit mapToFruit(FruitDto fruitDto){
        return new Fruit(
                fruitDto.getId(),
                fruitDto.getName(),
                fruitDto.getLatinName(),
                fruitDto.getDesc(),
                fruitDto.getCalories(),
                false
        );
    }
}
