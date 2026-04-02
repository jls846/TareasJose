package com.email.email_html_endpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import org.thymeleaf.context.Context;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailService;

    @Autowired
    private TemplateEngine templateEngine;

    public void MensajeHtmlEmail(String destinatario, String asunto, String nombre, String plantilla) throws MessagingException{
        MimeMessage mensaje = mailService.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje, true, "UTF-8");

        // configuracion de destinatiario y asunto
        Context context = new Context();
        context.setVariable("nombre", nombre);
        context.setVariable("codigo", plantilla);

        String contenidohtml = templateEngine.process("mensaje-html", context);

        helper.setTo(destinatario);
        helper.setSubject(asunto);
        helper.setText(contenidohtml, true);
        mailService.send(mensaje);
    }
}
