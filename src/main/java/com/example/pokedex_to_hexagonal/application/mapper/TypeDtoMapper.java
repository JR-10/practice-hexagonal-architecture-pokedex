package com.example.pokedex_to_hexagonal.application.mapper;

import com.example.pokedex_to_hexagonal.application.dto.TypeDto;
import com.example.pokedex_to_hexagonal.domain.model.Type;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* Como no se queria que se mostrara el id, entonces se crea ente mapeer intermedio
* */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TypeDtoMapper {

    /*
    * hace la conversion de Type a TypeDto
    * */

    TypeDto toDto(Type type);

}
