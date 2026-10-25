package com.register.api;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "usuarios")
@NoArgsConstructor
public class usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",nullable = false,unique = true,length = 120)
    private String nombre;

    @Column(name = "correo",nullable = false,unique = true,length = 100)
    private String mail;

    @Column(name = "clave", nullable = false,length = 100)
    private String password;

}