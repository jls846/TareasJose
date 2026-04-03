package com.openia.documentacion_openia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/DocSwagger")
@Tag(name = "DocSwagger", description = "Documentacion de Swagger")
public class DocSwagger {
    @Operation(summary = "Saludo Respuesta", description = "RESPUESTA DE SALUDO")
    @GetMapping("/saludo")
    public String saludo(){
        return "Hola Swagger";
    }
}
