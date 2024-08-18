package com.example.pokedex_to_hexagonal.infraestructure.exception;


/**
 * Es una excepcion personalizada, extiende de RuntimeException
 * */
public class PokemonAlreadyExistsException  extends RuntimeException{
    public PokemonAlreadyExistsException() {
        super();
    }
}
