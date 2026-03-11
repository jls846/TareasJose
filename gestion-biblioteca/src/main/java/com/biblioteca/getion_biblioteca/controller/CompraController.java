package com.biblioteca.getion_biblioteca.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.getion_biblioteca.model.Cliente;
import com.biblioteca.getion_biblioteca.model.Compra;
import com.biblioteca.getion_biblioteca.model.Libro;
import com.biblioteca.getion_biblioteca.repository.ClienteRepository;
import com.biblioteca.getion_biblioteca.repository.CompraRepository;
import com.biblioteca.getion_biblioteca.repository.LibroRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/compras")
@RequiredArgsConstructor
public class CompraController {
    private final CompraRepository compraRepository;
    private final ClienteRepository clienteRepository;
    private final LibroRepository libroRepository;

    @GetMapping
    public List<Compra> obtenerTodas() {
        return compraRepository.findAll();
    }

    @PostMapping("/registrar/cliente/{clienteId}/libro/{libroId}")
    public ResponseEntity<Compra> registrarCompra(
            @PathVariable Long clienteId,
            @PathVariable Long libroId,
            @RequestBody Compra compraDetalles) {

        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        Libro libro = libroRepository.findById(libroId).orElse(null);

        if (cliente == null || libro == null) {
            return ResponseEntity.notFound().build();
        }

        
        compraDetalles.setCliente(cliente);
        compraDetalles.setLibro(libro);
        
        Compra nuevaCompra = compraRepository.save(compraDetalles);
        return new ResponseEntity<>(nuevaCompra, HttpStatus.CREATED);
    }

    @GetMapping("/historial/cliente/{clienteId}")
    public ResponseEntity<List<Libro>> obtenerHistorialCliente(@PathVariable Long clienteId) {
        
        
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }

        List<Libro> librosComprados = libroRepository.encontrarLibrosPorCliente(clienteId);
        return ResponseEntity.ok(librosComprados);
    }
}
