package com.serviciorest.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import com.serviciorest.rest.dto.Email;
import org.thymeleaf.context.Context;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public void enviarCorreo(Email email) {
        try {
            MimeMessage mensaje = mailSender.createMimeMessage();
            // El 'true' indica que el mensaje es multipart (permite adjuntos/HTML)
            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true, "UTF-8");

            helper.setTo(email.getDestinatario());
            helper.setSubject(email.getAsunto());

            // 1. Crear el contexto de Thymeleaf (usa org.thymeleaf.context.Context)
            Context context = new Context();
            context.setVariable("nombre", email.getNombre());

            // 2. Procesar la plantilla (debe estar en src/main/resources/templates/email-template.html)
            String contenidoHtml = templateEngine.process("email-template", context);

            helper.setText(contenidoHtml, true); // true = enviar como HTML

            mailSender.send(mensaje);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al enviar el correo: " + e.getMessage());
        }
    }
}