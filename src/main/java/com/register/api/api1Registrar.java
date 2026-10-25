package com.register.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/usuarios")
public class api1Registrar {

    // Asignarle las caracteristicas del repositorio a nuestra clase y le asignamos
    // un nombre para usar , en este ejemplo repository
    private final usuariosRepository repository;

    // le asignamos de inmediato el repositorio a usar , parece redundante pero el tipo
    // private final , necesita si o si un valor ya definido si-no tira error.
    public api1Registrar(usuariosRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/registrar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new usuarios());
        return "registrar";
    }

    @PostMapping("/registrar")
    @ResponseBody
    public String registrate(@ModelAttribute usuarios cliente) {
        System.out.println("=== USUARIO RECIBIDO DESDE LA WEB ===");
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Mail: " + cliente.getMail());
        System.out.println("Contraseña: " + cliente.getPassword());


        RegistrarUsuario registro = new RegistrarUsuario(repository,cliente);
        registro.crear(registro.getCliente());

        return "¡Usuario " + cliente.getNombre() + " registrado con éxito!";
    }
}