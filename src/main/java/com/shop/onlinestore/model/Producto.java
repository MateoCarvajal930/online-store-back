package com.shop.onlinestore.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "producto")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 255)
    private String nombre;

    @Column(nullable = false, length = 255)
    private String marca;

    @Column(nullable = false, length = 255)
    private String categoria;

    @Column(nullable = false)
    private Float precio;

    @Column(nullable = true)
    private String descripcion;

    @Column(nullable = false, length = 255)
    private String tipoProducto;
}
