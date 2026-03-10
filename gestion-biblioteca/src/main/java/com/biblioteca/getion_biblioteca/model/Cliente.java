package com.biblioteca.getion_biblioteca.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "clientes")
public class Cliente {
    @Id
    private Long id;
    private String nombre;
    private String email;
    private String rfc;
    
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaEliminacion;
    private LocalDateTime fechaActualizacion;

    //Relacion con compra
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Compra> compras;

    @PrePersist
    protected void onCreate(){
        fechaRegistro = LocalDateTime.now();
    }
}
