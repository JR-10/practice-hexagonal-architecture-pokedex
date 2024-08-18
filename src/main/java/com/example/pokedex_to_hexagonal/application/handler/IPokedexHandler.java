package com.example.pokedex_to_hexagonal.application.handler;

import com.example.pokedex_to_hexagonal.application.dto.PokedexRequestDto;
import com.example.pokedex_to_hexagonal.application.dto.PokedexResponseDto;

import java.util.List;

/**
 * Manejador de errores
 * */
public interface IPokedexHandler {

    void savePokemonInPokedex(PokedexRequestDto pokedexRequestDto);

    List<PokedexResponseDto> getAllPokemonFromPokedex();

    PokedexResponseDto getPokemonFromPokedex(Long pokemonNumber);

    void updatePokemonInPokedex(PokedexRequestDto pokedexRequestDto);

    void deletePokemonFromPokedex(Long pokemonNumber);

}
