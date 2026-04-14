package com.serviciorest.rest.service;

import com.serviciorest.rest.dto.Email;

public interface EmailService {
    void enviarCorreo(Email email);
    
}
