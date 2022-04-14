package com.shop.onlinestore.service;

import com.shop.onlinestore.model.Producto;
import com.shop.onlinestore.repository.IProductoRepository;
import com.shop.onlinestore.service.imp.ProductoServiceImp;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IProductoServiceTest {

    IProductoRepository repository;

    ProductoServiceImp productoServiceImp;

    @BeforeEach
    void init() {
        repository = mock(IProductoRepository.class);
        productoServiceImp = new ProductoServiceImp(repository);
    }

    @Test
    void listAllWhenNonResult() {
        when(repository.findAll()).thenReturn(Collections.emptyList());

        List<Producto> productos = productoServiceImp.listAll();

        verify(repository, times(1)).findAll();
        assertEquals( "la lista no contiene 0 productos", 0, productos.size());
    }

    void listAllWhenResults() {
        when(repository.findAll()).thenReturn(obtenerListaProductos());

        List<Producto> productos = productoServiceImp.listAll();

        verify(repository, times(1)).findAll();
        assertEquals( "la lista no contiene 5 productos", 5, productos.size());
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void findOne() {
    }

    @Test
    void delete() {
    }

    @Test
    void findByName() {
    }

    private List<Producto> obtenerListaProductos() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto());
        productos.add(new Producto());
        productos.add(new Producto());
        productos.add(new Producto());
        productos.add(new Producto());
        return productos;
    }
}