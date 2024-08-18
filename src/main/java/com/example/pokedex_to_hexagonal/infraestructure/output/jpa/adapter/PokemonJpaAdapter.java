package com.example.pokedex_to_hexagonal.infraestructure.output.jpa.adapter;

import com.example.pokedex_to_hexagonal.domain.model.Pokemon;
import com.example.pokedex_to_hexagonal.domain.spi.IPokemonPersistencePort;
import com.example.pokedex_to_hexagonal.infraestructure.exception.NoDataFoundException;
import com.example.pokedex_to_hexagonal.infraestructure.exception.PokemonAlreadyExistsException;
import com.example.pokedex_to_hexagonal.infraestructure.exception.PokemonNotFoundException;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.entity.PokemonEntity;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.mapper.IPokemonEntityMapper;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.repository.IPokemonRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor // implementar constructor con lombok
public class PokemonJpaAdapter implements IPokemonPersistencePort {

    private final IPokemonRepository pokemonRepository;

    private final IPokemonEntityMapper pokemonEntityMapper;

    /*
    * Realizar validaciones a nivel de infraestructura
    * */

    @Override
    public void savePokemon(Pokemon pokemon) {
        if(pokemonRepository.findByNumber(pokemon.getNumber()).isPresent()) {
            throw new PokemonAlreadyExistsException();
        }
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        // se obtiene la lista por medio del repository metodo findAll()
        List<PokemonEntity> pokemonEntityList = pokemonRepository.findAll();
        if(pokemonEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return pokemonEntityMapper.toPokemonList(pokemonEntityList); // retorno de la lista
    }


    @Override
    public Pokemon getPokemonByNumber(Long pokemonNumber) {
        return pokemonEntityMapper.toPokemon(pokemonRepository.findByNumber(pokemonNumber)
                .orElseThrow(PokemonNotFoundException::new));
    }

    @Override
    public void updatePokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemonEntityMapper.toEntity(pokemon));
    }

    @Override
    public void deletePokemon(Long pokemonNumber) {
        pokemonRepository.deleteById(pokemonNumber);
    }
}
