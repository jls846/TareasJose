package com.serviciorest.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviciorest.rest.dto.Email;
import com.serviciorest.rest.service.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public String enviar(@RequestBody Email email){
        emailService.enviarCorreo(email);
        return "Correo enviado con exito" + email.getDestinatario()+ "!";
    }
}
