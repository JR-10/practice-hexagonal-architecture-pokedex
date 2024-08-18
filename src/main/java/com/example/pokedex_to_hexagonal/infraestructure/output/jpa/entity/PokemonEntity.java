package com.example.pokedex_to_hexagonal.infraestructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que es para el mapeo de la tabla en la BD
 * */

@Entity // indica que estamos trabajando con JPA
@Table(name = "pokemon" ) // definir el nombre que va a tener nuestra tabla
@NoArgsConstructor // definir constructor sin argumentos
@AllArgsConstructor // definir constructor con argumentos
@Getter
@Setter
public class PokemonEntity {

    @Id // define que es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // que es auto incrementable
    private Long id;
    private Long number;
    private String name;
    private Long typeId;
    private String photoId;

}
