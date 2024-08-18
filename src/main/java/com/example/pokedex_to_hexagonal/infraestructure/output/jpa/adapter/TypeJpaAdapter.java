package com.example.pokedex_to_hexagonal.infraestructure.output.jpa.adapter;

import com.example.pokedex_to_hexagonal.domain.model.Type;
import com.example.pokedex_to_hexagonal.domain.spi.ITypePersistencePort;
import com.example.pokedex_to_hexagonal.infraestructure.exception.NoDataFoundException;
import com.example.pokedex_to_hexagonal.infraestructure.exception.TypeNotFoundException;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.entity.TypeEntity;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.mapper.ITypeEntityMapper;
import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.repository.ITypeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor //
public class TypeJpaAdapter implements ITypePersistencePort {

    private final ITypeRepository typeRepository;
    private final ITypeEntityMapper typeEntityMapper;

    @Override
    public Type saveType(Type type) {
        return typeEntityMapper.toType(typeRepository.save(typeEntityMapper.toEntity(type)));
    }

    @Override
    public List<Type> getAllTypes() {
        List<TypeEntity> typeEntityList = typeRepository.findAll();
        if(typeEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return typeEntityMapper.toTypeList(typeEntityList);
    }

    @Override
    public Type getTypeByTypeId(Long typeId) {
        return typeEntityMapper.toType(typeRepository.findById(typeId)
                .orElseThrow(TypeNotFoundException::new));
    }

    @Override
    public void updateType(Type type) {
        typeRepository.save(typeEntityMapper.toEntity(type));
    }

    @Override
    public void deleteType(Long typeId) {
        typeRepository.deleteById(typeId);
    }
}
