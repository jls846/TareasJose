package com.biblioteca.getion_biblioteca.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.getion_biblioteca.model.Libro;
import com.biblioteca.getion_biblioteca.repository.LibroRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;@RestController
@RequestMapping("/libros")
@RequiredArgsConstructor // Genera el constructor para el repositorio automáticamente
public class LibroController {

    private final LibroRepository libroRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Long id) {
        return libroRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // Devuelve 404 si no existe
    }

    @PostMapping
    public ResponseEntity<Libro> guardarLibro(@RequestBody Libro libro) {
        Libro nuevoLibro = libroRepository.save(libro);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED); // Devuelve 201
    }
}
