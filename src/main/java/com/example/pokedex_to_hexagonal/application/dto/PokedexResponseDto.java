package com.example.pokedex_to_hexagonal.application.dto;

import com.example.pokedex_to_hexagonal.domain.model.Type;
import lombok.Getter;
import lombok.Setter;

/**
 * Retorno de la data al cliente
 * */
@Getter
@Setter
public class PokedexResponseDto {

    private Long number;
    private String name;
    private TypeDto types;
    private String  photo;


}
