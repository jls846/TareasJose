package com.serviciorest.rest.dto;


public class Email {
    private String destinatario;
    private String nombre;
    private String asunto;

    public Email() {}

    
    public String getDestinatario() { return destinatario; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }
}
