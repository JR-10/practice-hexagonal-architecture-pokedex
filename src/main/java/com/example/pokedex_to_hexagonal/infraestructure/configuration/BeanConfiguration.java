package com.example.pokedex_to_hexagonal.infraestructure.configuration;

import com.example.pokedex_to_hexagonal.domain.api.IPokemonServicePort;
import com.example.pokedex_to_hexagonal.domain.api.ITypeServicePort;
import com.example.pokedex_to_hexagonal.domain.spi.IPokemonPersistencePort;
import com.example.pokedex_to_hexagonal.domain.spi.ITypePersistencePort;
import com.example.pokedex_to_hexagonal.domain.usecase.PokemonUseCase;
import com.example.pokedex_to_hexagonal.domain.usecase.TypeUseCase;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.adapter.PokemonJpaAdapter;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.adapter.TypeJpaAdapter;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.mapper.IPokemonEntityMapper;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.mapper.ITypeEntityMapper;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.repository.IPokemonRepository;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.repository.ITypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Esta clase nos sirve para indicarle a Spring que lo que esta en el Dominio lo tiene que trabajar con Beans desde fuera
 * */

@Configuration // anotacion para indicar que es clase de configuracion
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IPokemonRepository pokemonRepository;
    private final IPokemonEntityMapper pokemonEntityMapper;
    private final ITypeRepository typeRepository;
    private final ITypeEntityMapper typeEntityMapper;


    @Bean
    public IPokemonPersistencePort pokemonPersistencePort() {
        return new PokemonJpaAdapter(pokemonRepository, pokemonEntityMapper);
    }

    @Bean
    public IPokemonServicePort pokemonServicePort() {
        return new PokemonUseCase(pokemonPersistencePort());
    }



    @Bean
    public ITypePersistencePort typePersistencePort() {
        return new TypeJpaAdapter(typeRepository, typeEntityMapper);
    }

    @Bean
    public ITypeServicePort typeServicePort() {
        return new TypeUseCase(typePersistencePort());
    }
}
