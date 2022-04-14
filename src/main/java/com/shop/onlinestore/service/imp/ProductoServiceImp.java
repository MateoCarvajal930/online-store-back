package com.shop.onlinestore.service.imp;

import com.shop.onlinestore.exceptions.ResourceNotFoundException;
import com.shop.onlinestore.model.Producto;
import com.shop.onlinestore.repository.IProductoRepository;
import com.shop.onlinestore.service.IProductoService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImp implements IProductoService {

    private final IProductoRepository productoRepo;

    public ProductoServiceImp(IProductoRepository productoRepo) {
        this.productoRepo = productoRepo;
    }

    @Override
    public List<Producto> listAll() {
        return productoRepo.findAll();
    }
    @Override
    public Producto save(Producto producto) {

        return productoRepo.save(producto);
    }

    @Override
    public Producto update(Long id, Producto producto) {
        Producto productoActulizar = findOne(id);
        productoActulizar.setNombre(producto.getNombre());
        productoActulizar.setMarca(producto.getMarca());
        productoActulizar.setCategoria(producto.getCategoria());
        productoActulizar.setPrecio(producto.getPrecio());
        return productoRepo.save(producto);
    }

    @Override
    public Producto findOne(Long id) {
        return productoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el ID: " + id));
    }

    @Override
    public void delete(Long id) {
        findOne(id);
        productoRepo.deleteById(id);
    }

    @Override
    public List<Producto> findByName(String name) {
        return productoRepo.findByNombreContains(name);
    }

}
