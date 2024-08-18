package com.example.pokedex_to_hexagonal.application.dto;

import com.example.pokedex_to_hexagonal.domain.model.Type;
import lombok.Getter;
import lombok.Setter;

/*
* Se implementa la libreria Lombok para la creacion de Getters y Setters
* */

@Getter
@Setter
public class PokedexRequestDto {

    private Long number;
    private String name;
    private Type types;
    private String  photo;


}
