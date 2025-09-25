package br.unipar.devbackend.livrariaunipar.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping("/helloworld")

    public String hellowolrd(){

        return "Hello World";
    }

}


// http://localhost:8080/usuarios/helloworld