package com.shop.onlinestore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductoDTO {
    private Long id;
    private String nombre;
    private String marca;
    private String categoria;
    private String precio;
}
