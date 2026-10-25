package com.register.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

// Metodo que usaremos para registrar utilizando las funciones ya establecida en la
// interface de repositorio que hemos creado
public class RegistrarUsuario {

    private final usuariosRepository repository;
    private usuarios cliente;

    public usuarios crear(usuarios cliente){
        cliente.setId(null);
        return repository.save(cliente);
    }

}
