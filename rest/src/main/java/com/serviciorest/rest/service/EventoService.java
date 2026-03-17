package com.serviciorest.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviciorest.rest.models.Evento;
import com.serviciorest.rest.repository.EventoRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    //Insertar un nuevo evneto
    public Evento guardarEvento(Evento evento){
        return eventoRepository.save(evento);
    }

    //obtener todos los evento en forma de lista
    public List<Evento> obtenerTodosLosEventos(){
        return eventoRepository.findAll();
    }

    public Evento buscarEventoPorNombre(String nombre){
        return eventoRepository.findByNombre(nombre);
    }


}
