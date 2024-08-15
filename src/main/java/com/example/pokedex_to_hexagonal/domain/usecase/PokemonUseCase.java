package com.example.pokedex_to_hexagonal.domain.usecase;


import com.example.pokedex_to_hexagonal.domain.model.Pokemon;
import com.example.pokedex_to_hexagonal.domain.api.IPokemonServicePort;
import com.example.pokedex_to_hexagonal.domain.spi.IPokemonPersistencePort;

import java.util.List;

/**
 * Los casos de uso dentro del dominio se encargan de implementar las api
 * que se encuentran en el dominio y van a ser utilizados por los elementos externos
 * */
public class PokemonUseCase implements IPokemonServicePort {

    /*
    * normalmente se utiliza el Autowired para injectar dependencias pero esto es una mala practica,
    * por lo tanto se deben hacer es por medio de inyecciones a travez del constructor de la clase
    *  (La injeccion de dependencias es un patron Singleton)
    * */
    private final IPokemonPersistencePort pokemonPersistencePort;

    public PokemonUseCase(IPokemonPersistencePort pokemonPersistencePort) {
        this.pokemonPersistencePort = pokemonPersistencePort;
    }

    @Override
    public void savePokemon(Pokemon pokemon) {
        pokemonPersistencePort.savePokemon(pokemon); // utilizar la clase que va a implemntar la interfaz que estamos declarando
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        return pokemonPersistencePort.getAllPokemon();
    }

    @Override
    public Pokemon getPokemonByNumber(Long pokemonNumber) {
        return pokemonPersistencePort.getPokemonByNumber(pokemonNumber);
    }

    @Override
    public void updatePokemon(Pokemon pokemon) {
        pokemonPersistencePort.updatePokemon(pokemon);
    }

    @Override
    public void deletePokemon(Long pokemonNumber) {
        pokemonPersistencePort.deletePokemon(pokemonNumber);
    }
}
