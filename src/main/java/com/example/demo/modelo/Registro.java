package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "registro")
public class Registro {
    
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "itoken", length = 32,unique = true)
    private int id;
    
    @Getter
    @Setter
    @Column(name = "usuario", length = 32,unique = true, nullable = false)
    private String usuario;
    
    @Getter
    @Setter
    @Column(name = "contrasenha", length = 256, nullable = false)
    private String contrasenha;
    
    
    public Registro() {
    }

    public Registro(String usuario, String contrasenha) {
        this.usuario = usuario;
        this.contrasenha = contrasenha;
    }

    @Override
    public String toString() {
        return "Registro{" + " id = " + id + ", usuario = " + usuario + ", contrasenha = " + contrasenha + '}';
    }

    
}
