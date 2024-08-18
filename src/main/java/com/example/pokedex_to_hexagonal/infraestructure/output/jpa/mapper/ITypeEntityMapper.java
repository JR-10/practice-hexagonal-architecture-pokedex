package com.example.pokedex_to_hexagonal.infraestructure.output.jpa.mapper;

import com.example.pokedex_to_hexagonal.domain.model.Type;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.entity.TypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITypeEntityMapper {

    TypeEntity toEntity(Type type); // mapeo de Type a Entidad

    Type toType(TypeEntity typeEntity); // mapeo de Entidad a Type

    List<Type> toTypeList(List<TypeEntity> typeEntityList); // mapeo de lista Entidad a lista de Type
}
