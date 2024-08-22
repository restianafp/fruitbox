package com.bootcamp.fruitbox.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FruitDto {
    private Long id;
    private String name;
    private String latinName;
    private String desc;
    private int calories;
}
