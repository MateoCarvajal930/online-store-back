package com.shop.onlinestore.service;

import com.shop.onlinestore.model.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> listAll();
    Producto save(Producto producto);
    Producto update(Long id, Producto producto);
    Producto findOne(Long id);
    void delete(Long id);
    List<Producto> findByName(String name);
    List<Producto> findByMarca(String marca);
    List<Producto> findByCategoria(String categoria);
    List<Producto> findByTipo(String tipo);
}
