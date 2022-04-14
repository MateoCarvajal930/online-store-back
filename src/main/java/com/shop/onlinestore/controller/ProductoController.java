package com.shop.onlinestore.controller;

import com.shop.onlinestore.dto.ProductoDTO;
import com.shop.onlinestore.dto.ProductoTransformer;
import com.shop.onlinestore.model.Producto;
import com.shop.onlinestore.repository.IProductoRepository;
import com.shop.onlinestore.service.IProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {


    private final IProductoService productoService;

    private final IProductoRepository productoRepo;

    public ProductoController(IProductoService service, IProductoRepository productoRepo) {
        this.productoService = service;
        this.productoRepo = productoRepo;
    }

    //metodo para listar todos los productos
    @GetMapping
    public List<Producto> listarTodo() {
        return productoService.listAll();
    }

    //metodo para insertar producto
    @PostMapping
    public Producto insertarProducto(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        Producto producto = productoService.findOne(id);
        return ResponseEntity.ok(producto);
    }

    @GetMapping("/list-by-name/{name}")
    public ResponseEntity<List<Producto>> obtenerProductosPorNombre(@PathVariable String name) {
        List<Producto> productosList = productoService.findByName(name);
        return ResponseEntity.ok(productosList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable Long id, @RequestBody ProductoDTO detallesProducto) {
        Producto update = productoService.update(id, ProductoTransformer.toModel(detallesProducto));
        return ResponseEntity.ok(ProductoTransformer.toDTO(update));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable Long id) {
        productoService.delete(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
