package com.bootcamp.fruitbox.service;

import com.bootcamp.fruitbox.dto.FruitDto;

import java.util.List;

public interface FruitService {
    FruitDto create(FruitDto fruitDto);

    FruitDto getById(Long fruitId);

    List<FruitDto> getAll();

    FruitDto update(Long id, FruitDto updatedFruitDto);

    void softDelete(Long id);
}
