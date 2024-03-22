package com.cafe.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe.cafe.persistences.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
