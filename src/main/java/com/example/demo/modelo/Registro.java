package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Registro")
public class Registro {
    
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "itoken", length = 32,unique = true)
    private int id;
    
    @Getter
    @Setter
    @Column(name = "Usuario", length = 32,unique = true, nullable = false)
    private String usuario;
    
    @Getter
    @Setter
    @Column(name = "Contrasenha", length = 256, nullable = false)
    private String contrasenha;
    
    
    public Registro() {
    }

    public Registro(String usuario, String contrasenha) {
        this.usuario = usuario;
        this.contrasenha = contrasenha;
    }
    
@PrePersist
public void prePersist() {
    if (contrasenha != null) {
        try {
            // Selecciona el algoritmo de hash (en este caso, SHA-256)
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Convierte la contraseña en bytes y calcula el hash
            byte[] hashedBytes = md.digest(contrasenha.getBytes());

            // Convierte el hash en una representación hexadecimal
            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
                hexStringBuilder.append(String.format("%02x", hashedByte));
            }

            // Asigna el hash al campo de contraseña antes de persistir
            contrasenha = hexStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            // Manejo de excepciones en caso de que no se encuentre el algoritmo
            e.printStackTrace();
            // Puedes lanzar una excepción específica aquí si lo deseas
        }
    }
}

}
