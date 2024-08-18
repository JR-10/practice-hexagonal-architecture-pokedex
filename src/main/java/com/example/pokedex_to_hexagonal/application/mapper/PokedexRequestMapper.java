package com.example.pokedex_to_hexagonal.application.mapper;

import com.example.pokedex_to_hexagonal.application.dto.PokedexRequestDto;
import com.example.pokedex_to_hexagonal.domain.model.Photo;
import com.example.pokedex_to_hexagonal.domain.model.Pokemon;
import com.example.pokedex_to_hexagonal.domain.model.Type;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Base64;

/**
 * Convertir de la RequesDto a Pokemon, RequesDto a Photo
 * */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PokedexRequestMapper {

    Pokemon toPokemon(PokedexRequestDto pokedexRequestDto);

    @Mapping(source = "pokedexRequestDto.types.firstType", target = "firstType")
    @Mapping(source = "pokedexRequestDto.types.firstType", target = "firstType")
    Type toType(PokedexRequestDto pokedexRequestDto);


    @Mapping(target = "photo", qualifiedByName = "base64ToByteArray")
    Photo toPhoto(PokedexRequestDto pokedexRequestDto);

    @Named("base64ToByteArray")
    static byte[] base64ToByteArray(String base64Photo) {
        return Base64.getDecoder().decode(base64Photo);
    }
}
