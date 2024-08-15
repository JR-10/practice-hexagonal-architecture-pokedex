package com.example.pokedex_to_hexagonal.application.dto;

import com.example.pokedex_to_hexagonal.domain.model.Type;

/*
* Se implementa la libreria Lombok para la creacion de Getters y Setters
* */
public class PokedexrequestDto {

    private Long number;
    private String name;
    private Type types;
    private String  photo;


}
