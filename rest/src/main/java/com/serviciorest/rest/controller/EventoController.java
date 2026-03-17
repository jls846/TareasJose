package com.serviciorest.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serviciorest.rest.models.Evento;
import com.serviciorest.rest.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    //insertar un nuevo evento
    @PostMapping("/crear")
    public Evento crearEvento(@RequestBody Evento evento){
        return eventoService.guardarEvento(evento);
    }

    //Para obtener todos los eventos, se puede usar un metodo GET
    @GetMapping("/todos")
    public List<Evento> listarTodos(){
        return eventoService.obtenerTodosLosEventos();
    }

    //Para buscar un evento por su nombre, se puede usar un metodo GET con un parametro de consulta
    @GetMapping("/buscar")
    public Evento buscarPorNombre(@RequestParam String nombre){
        return eventoService.buscarEventoPorNombre(nombre);
    }
}
