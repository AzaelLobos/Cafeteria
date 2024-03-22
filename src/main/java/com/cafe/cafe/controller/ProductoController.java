package com.cafe.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe.cafe.persistences.entities.Producto;
import com.cafe.cafe.service.producto.ProductoService;


@Controller
public class ProductoController {
 
    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public String listarProductos(Model model){
        List<Producto> producto = productoService.findAll();
        model.addAttribute("productos", producto);
        return "productos.html";
    }
    
    @GetMapping("/productos/nuevo")
    public String add(Model model){
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        return "crear_producto";
    }

    @PostMapping("/productos")
    public String save(@ModelAttribute("producto") Producto producto){
        productoService.guardarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String editarProducto(@PathVariable Long id, Model model){
        model.addAttribute("producto", productoService.buscarPorId(id));
        return "editar_producto";
    }

    @PostMapping("/productos/{id}")
    public String updateProducto(@PathVariable Long id, @ModelAttribute("producto") Producto producto, Model model){
        Producto productoE = productoService.buscarPorId(id);
        productoE.setId(id);
        productoE.setNombre(producto.getNombre());
        productoE.setDescripcion(producto.getDescripcion());
        productoE.setPrecio(producto.getPrecio());
        productoE.setCantidad(producto.getCantidad());
        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}")
    public String delete(@PathVariable Long id){
        productoService.delete(id);
        return "redirect:/productos";
    }
}
