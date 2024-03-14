package com.example.demo.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    
    
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Getter
    @Setter
    long id;
    
    @Getter
    @Setter
    @Column(name = "nombres", length = 62, nullable = false, unique = true, updatable = false)
    private String Nombres;
    
    @Getter
    @Setter
    @Column(name = "apellidos", length = 62, nullable = false, unique = true, updatable = false)
    private String Apellidos;
    
    @Getter
    @Setter
    @Column(name = "documento", length = 12, nullable = false ,updatable = false)
    private String Documento;
    
    
    @Getter
    @Setter
    @Column(name = "correo_electronico", length = 62, updatable = true)
    private String Correo_electronico;
    
    @Getter
    @Setter
    @Column(name = "tarjeta_sitp", length = 15, updatable = true)
    private String Tarjeta_sitp;
    
    @Getter
    @Setter
    @Column(name = "telefono", length = 12, updatable = true)
    private String Telefono;
   

    public Usuario(long id, String Nombres, String Apellidos, String Documento, String Correo_electronico, String Tarjeta_sitp, String Telefono) {
        this.id = id;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Documento = Documento;
        this.Correo_electronico = Correo_electronico;
        this.Tarjeta_sitp = Tarjeta_sitp;
        this.Telefono = Telefono;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" + "id =" + id + ", Nombres = " + Nombres + ", Apellidos = " + Apellidos + ", Documento = " + Documento + ", Correo_electronico = " + Correo_electronico + ", Tarjeta_sitp = " + Tarjeta_sitp + ", Telefono = " + Telefono + '}';
    }
    

}
