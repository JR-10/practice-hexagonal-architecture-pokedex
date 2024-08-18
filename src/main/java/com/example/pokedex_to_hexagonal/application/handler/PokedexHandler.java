package com.example.pokedex_to_hexagonal.application.handler;

import com.example.pokedex_to_hexagonal.application.dto.PokedexRequestDto;
import com.example.pokedex_to_hexagonal.application.dto.PokedexResponseDto;
import com.example.pokedex_to_hexagonal.application.mapper.PokedexRequestMapper;
import com.example.pokedex_to_hexagonal.application.mapper.PokedexResponseMapper;
import com.example.pokedex_to_hexagonal.application.mapper.TypeDtoMapper;
import com.example.pokedex_to_hexagonal.domain.api.IPhotoServicePort;
import com.example.pokedex_to_hexagonal.domain.api.IPokemonServicePort;
import com.example.pokedex_to_hexagonal.domain.api.ITypeServicePort;
import com.example.pokedex_to_hexagonal.domain.model.Photo;
import com.example.pokedex_to_hexagonal.domain.model.Pokemon;
import com.example.pokedex_to_hexagonal.domain.model.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * implementar la interfaz de IPokedexHandler
 * Usar anotaciones para incceciones: -> indica a spring que este elemento hace parte de lo que se maneja como beans para injeccion de dependencias
 *  @Service -> se cataloga como un servicio
 *  @RequiredArgsConstructor -> tomar todos los atributos como privados y finales y los anade por medio del constructor
 *  @Transaccional -> para transacciones con BD
 * */



@Service
@RequiredArgsConstructor
@Transactional
public class PokedexHandler implements IPokedexHandler {

    private final IPokemonServicePort pokemonServicePort;
    private final ITypeServicePort typeServicePort;
    private final IPhotoServicePort photoServicePort;
    private final PokedexRequestMapper pokedexRequestMapper;
    private final PokedexResponseMapper pokedexResponseMapper;
    private final TypeDtoMapper typeDtoMapper;


    /* Guardar un pokemon en la pokedex*/
    @Override
    public void savePokemonInPokedex(PokedexRequestDto pokedexRequestDto) {
        Type type = typeServicePort.saveType(pokedexRequestMapper.toType(pokedexRequestDto));
        Photo photo = photoServicePort.savePhoto(pokedexRequestMapper.toPhoto(pokedexRequestDto));
        Pokemon pokemon = pokedexRequestMapper.toPokemon(pokedexRequestDto);
        pokemon.setId(type.getId());
        pokemon.setPhotoId(photo.getId());
        pokemonServicePort.savePokemon(pokemon);
    }

    @Override
    public List<PokedexResponseDto> getAllPokemonFromPokedex() {
        return pokedexResponseMapper.toResponseList(pokemonServicePort.getAllPokemon(), typeServicePort.getAllTypes(), photoServicePort.getAllPhotos());
    }

    @Override
    public PokedexResponseDto getPokemonFromPokedex(Long pokemonNumber) {
        /* validar si el pokemon existe */
        Pokemon pokemon = pokemonServicePort.getPokemonByNumber(pokemonNumber); // llamar al pokemon
        // mapear a un formato de respuesta
        return pokedexResponseMapper.toResponse(pokemon, typeDtoMapper.toDto(typeServicePort.getTypeByTypeId(pokemon.getTypeId())), photoServicePort.getPhotoByPhotoId(pokemon.getPhotoId()));
    }

    @Override
    public void updatePokemonInPokedex(PokedexRequestDto pokedexRequestDto) {
        // obtener pokemon
        Pokemon oldPokemon = pokemonServicePort.getPokemonByNumber(pokedexRequestDto.getNumber());

        // setear nuevo tipo y enviar para actualizar
        Type newType = pokedexRequestMapper.toType(pokedexRequestDto);
        newType.setId(oldPokemon.getTypeId());
        typeServicePort.updateType(newType);

        // setear nueva photo y enviar para actualizar
        Photo newPhoto = pokedexRequestMapper.toPhoto(pokedexRequestDto);
        newPhoto.setId(oldPokemon.getPhotoId());
        photoServicePort.updatePhoto(newPhoto);

        // setear nuevo pokemon y enviar para actualizar
        Pokemon newPokemon = pokedexRequestMapper.toPokemon(pokedexRequestDto);
        newPokemon.setId(oldPokemon.getId());
        newPokemon.setTypeId(oldPokemon.getTypeId());
        newPokemon.setPhotoId(oldPokemon.getPhotoId());
        pokemonServicePort.updatePokemon(newPokemon);
    }

    @Override
    public void deletePokemonFromPokedex(Long pokemonNumber) {
        // obtener pokemon
        Pokemon pokemon = pokemonServicePort.getPokemonByNumber(pokemonNumber);

        // eliminar tipo
        typeServicePort.deleteTypeById(pokemon.getTypeId());

        // eliminar photo
        photoServicePort.deletePhoto(pokemon.getPhotoId());

        // eliminar pokemon
        pokemonServicePort.deletePokemon(pokemonNumber);
    }
}
