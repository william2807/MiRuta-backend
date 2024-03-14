package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*Se toma como entidad en la base de datos para que pueda ser persistida*/
@Entity
/*Nombre de la tabla en general que se vera reflejada en la base de datos*/
@Table(name = "Rutas")
public class Rutas {
    
    @Getter
    @Setter
    /*Se verifica que es un id*/
    @Id
    /*Nombre de la tabla en la cual se reflejara en la base de datos*/
    @Column(name = "id")
    /*Genearacion del id automaticamente*/
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    
    @Getter
    @Setter
    /*    nombre de tabla, tamaño  ,  nulo     ,  es unico            ,no se puede volver a modificar*/   
    @Column(name = "ruta", length = 5, nullable = false, unique = true, updatable = false)
    private String ruta_comercial;
    
    @Getter
    @Setter
    @Column(name = "linea", length = 6, nullable = false)
    private int linea;
    
    @Getter
    @Setter
    @Column(name = "tipo_servicio", length = 12, nullable = false)
    private String tipo_servicio;
    
    @Getter
    @Setter
    @Column(name = "operador", length = 32 ,nullable = false)
    private String operador;
    
    @Getter
    @Setter
    @Column(name = "inicio_final", length = 48,nullable = false)
    private String origen_destino;
    
    @Getter
    @Setter
    @Column(name = "inicio_recorrido",length = 4,nullable = false)
    private String zona_origen;
    
    @Getter
    @Setter
    @Column(name = "zona_destino", length = 4,nullable = false)
    private String zona_destino;

    public Rutas() {
    }
    
    public Rutas(Long  id,String ruta_comercial, int linea, String tipo_servicio, String operador, String origen_destino, String zona_origen, String zona_destino) {
        this.id = id;
        this.ruta_comercial = ruta_comercial;
        this.linea = linea;
        this.tipo_servicio = tipo_servicio;
        this.operador = operador;
        this.origen_destino = origen_destino;
        this.zona_origen = zona_origen;
        this.zona_destino = zona_destino;
    } 
}