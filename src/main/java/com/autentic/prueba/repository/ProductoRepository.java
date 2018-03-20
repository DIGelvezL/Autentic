package com.autentic.prueba.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.autentic.prueba.model.entities.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer>{

}
