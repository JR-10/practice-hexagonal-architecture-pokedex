package com.example.pokedex_to_hexagonal.infraestructure.output.jpa.repository;


import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * facilita las consultas em spring
 * */
public interface IPokemonRepository extends JpaRepository<PokemonEntity, Long> {

    // derivacion por metodo -> utilizar querys sin @Query
    // retorna el dato como opcional por si el dato no esta en la BD y hacerle tratamiento de excepciones
    Optional<PokemonEntity> findByNumber(Long pokemonNumber);

    void deleteByNumber(Long pokemonNumber);



}
