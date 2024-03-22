package com.cafe.cafe.service.producto;

import java.util.List;

import com.cafe.cafe.persistences.entities.Producto;

public interface ProductoService{
    
    public List<Producto> findAll();
    public Producto guardarProducto(Producto producto);
    public Producto buscarPorId(Long id);
    public Producto update(Producto producto);
    public void delete(Long id);
}
