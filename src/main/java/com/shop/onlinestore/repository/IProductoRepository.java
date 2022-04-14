package com.shop.onlinestore.repository;

import com.shop.onlinestore.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
    @Query("select p from Producto p where p.nombre like %:name% ")
    List<Producto> findByNombreContains(@Param("name") String name);
}
