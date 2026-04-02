package com.email.email_html_endpoint.dto;

import lombok.Data;

@Data
public class EmailRequest {
    private String destinatario;
    private String nombre;
}
