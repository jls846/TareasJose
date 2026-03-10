package com.biblioteca.getion_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.getion_biblioteca.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
