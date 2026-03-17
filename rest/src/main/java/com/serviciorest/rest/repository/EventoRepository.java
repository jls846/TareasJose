package com.serviciorest.rest.repository;

import javax.print.DocFlavor.STRING;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviciorest.rest.models.Evento;

public interface EventoRepository  extends JpaRepository<Evento, Long>{
    Evento findByNombre(String nombre);

}
