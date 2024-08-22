package com.bootcamp.fruitbox.service.impl;

import com.bootcamp.fruitbox.dto.FruitDto;
import com.bootcamp.fruitbox.entity.Fruit;
import com.bootcamp.fruitbox.exception.ResourceNotFoundException;
import com.bootcamp.fruitbox.mapper.FruitMapper;
import com.bootcamp.fruitbox.repository.FruitRepository;
import com.bootcamp.fruitbox.service.FruitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FruitServiceImpl implements FruitService {

    private FruitRepository fruitRepository;

    @Override
    public FruitDto create(FruitDto fruitDto) {
        Fruit fruit = FruitMapper.mapToFruit(fruitDto);
        Fruit savedData = fruitRepository.save(fruit);
        return FruitMapper.mapToFruitDto(savedData);
    }

    @Override
    public FruitDto getById(Long fruitId) {
        Fruit fruit = fruitRepository.findByIdAndNotDeleted(fruitId)
                .orElseThrow(() -> new ResourceNotFoundException("Tidak ditemukan data buah dengan id : " + fruitId));
        return FruitMapper.mapToFruitDto(fruit);
    }

    @Override
    public List<FruitDto> getAll() {
        List<Fruit> fruits = fruitRepository.findAllActive();
        return fruits.stream().map((fruit) -> FruitMapper.mapToFruitDto(fruit))
                .collect(Collectors.toList());
    }

    @Override
    public FruitDto update(Long id, FruitDto updatedFruitDto) {
        Fruit fruit = fruitRepository.findByIdAndNotDeleted(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tidak ditemukan data buah dengan id : " + id));

        fruit.setName(updatedFruitDto.getName());
        fruit.setLatinName(updatedFruitDto.getLatinName());
        fruit.setDesc(updatedFruitDto.getDesc());
        fruit.setCalories(updatedFruitDto.getCalories());

        Fruit updatedData = fruitRepository.save(fruit);

        return FruitMapper.mapToFruitDto(updatedData);
    }

    @Override
    public void softDelete(Long id) {
        Fruit fruit = fruitRepository.findByIdAndNotDeleted(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tidak ditemukan data buah dengan id : " + id));
        fruit.setDeleted(true);
        fruitRepository.save(fruit);
    }
}
