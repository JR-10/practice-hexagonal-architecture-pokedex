package com.example.pokedex_to_hexagonal.domain.spi;


import com.example.pokedex_to_hexagonal.domain.model.Type;

import java.util.List;

public interface ITypePersistencePort {

    Type saveType(Type pokemon);

    List<Type> getAllTypes();

    Type getTypeByTypeId(Long typeId);

    void updateType(Type type);

    void deleteType(Long typeId);

}
