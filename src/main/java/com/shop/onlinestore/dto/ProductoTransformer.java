package com.shop.onlinestore.dto;

import com.shop.onlinestore.model.Producto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductoTransformer {
    public Producto toModel(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setId(productoDTO.getId());
        producto.setNombre(productoDTO.getNombre());
        producto.setMarca(productoDTO.getMarca());
        producto.setPrecio(Float.parseFloat(productoDTO.getPrecio()));
        producto.setCategoria(productoDTO.getCategoria());
        return producto;
    }

    public ProductoDTO toDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO(producto.getId(),"Querido" +  producto.getNombre(),
                producto.getMarca(),
                producto.getCategoria(),
                String.format("%.2f", producto.getPrecio()));
        return productoDTO;

    }
}
