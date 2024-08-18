package com.example.pokedex_to_hexagonal.infraestructure.output.jpa.repository;

import com.example.pokedex_to_hexagonal.infraestructure.output.jpa.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeRepository extends JpaRepository<TypeEntity, Long> {
}
