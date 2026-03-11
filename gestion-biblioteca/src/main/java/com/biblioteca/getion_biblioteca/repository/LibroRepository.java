package com.biblioteca.getion_biblioteca.repository;

import com.biblioteca.getion_biblioteca.model.Libro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query("SELECT c.libro FROM Compra c WHERE c.cliente.id = :clienteId")
    List<Libro> encontrarLibrosPorCliente(@Param("clienteId") Long clienteId);
}
