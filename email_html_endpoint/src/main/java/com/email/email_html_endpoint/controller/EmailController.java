package com.email.email_html_endpoint.controller;

import com.email.email_html_endpoint.dto.EmailRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.email_html_endpoint.service.EmailService;


@RestController
@RequestMapping("/mensaje")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarCorreo(@RequestBody EmailRequest request){
        try {
            emailService.MensajeHtmlEmail(
                request.getDestinatario(),
                "Tarea endPointEmail",
                request.getNombre(),
                "plantilla");
                return ResponseEntity.ok("Correo enviado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al enviar el correo"+ e.getMessage());
        }
    }
}
