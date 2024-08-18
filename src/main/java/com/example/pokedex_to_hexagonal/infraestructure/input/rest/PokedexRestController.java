package com.example.pokedex_to_hexagonal.infraestructure.input.rest;


import com.example.pokedex_to_hexagonal.application.dto.PokedexRequestDto;
import com.example.pokedex_to_hexagonal.application.dto.PokedexResponseDto;
import com.example.pokedex_to_hexagonal.application.handler.IPokedexHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // anotacion para definicion de controlador
@RequestMapping // anotacion para identificar ruta principal del servicio
@RequiredArgsConstructor // anotacion para injeccion de dependicas con Lombok
public class PokedexRestController {

    private final IPokedexHandler pokedexHandler;

    @PostMapping("/")
    public ResponseEntity<Void> savePokemonInPokedex(@RequestBody PokedexRequestDto pokedexRequestDto) {
        pokedexHandler.savePokemonInPokedex(pokedexRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<PokedexResponseDto>> getAllPokemonFromPokedex() {
        return ResponseEntity.ok(pokedexHandler.getAllPokemonFromPokedex());
    }

    @GetMapping("/{number}")
    public ResponseEntity<PokedexResponseDto> getPokemonFromPokedex(@PathVariable(name = "number") Long pokemonNumber ) {
        return ResponseEntity.ok(pokedexHandler.getPokemonFromPokedex(pokemonNumber));
    }

    @PutMapping("/")
    public ResponseEntity<Void> updatePokemonInPokedex(@RequestBody PokedexRequestDto pokedexRequestDto) {
        pokedexHandler.updatePokemonInPokedex(pokedexRequestDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{pokemonNumber}")
    public ResponseEntity<Void> deletePokemonFromPokedex(@PathVariable Long pokemonNumber) {
        pokedexHandler.deletePokemonFromPokedex(pokemonNumber);
        return ResponseEntity.noContent().build();
    }

}
