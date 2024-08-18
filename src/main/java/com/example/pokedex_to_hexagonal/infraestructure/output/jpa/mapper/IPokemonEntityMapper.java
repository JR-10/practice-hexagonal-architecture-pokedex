package com.example.pokedex_to_hexagonal.infraestructure.output.jpa.mapper;


import com.example.pokedex_to_hexagonal.domain.model.Pokemon;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.entity.PokemonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPokemonEntityMapper {

    PokemonEntity toEntity(Pokemon pokemon); // mapeo de Pokemon a Entidad

    Pokemon toPokemon(PokemonEntity pokemonEntity); // mapeo de Entidad a Pokemon

    List<Pokemon> toPokemonList(List<PokemonEntity> pokemonEntityList); // mapeo de lista de Entidad a lista de Pokemon

}
