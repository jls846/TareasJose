package com.serviciorest.rest.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Ususario {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)

    private Long id;
    private String nombre;
    private String email;

    @OneToMany(mappedBy = "usuario")
    private List<Inscripcion> inscepciones;
}
