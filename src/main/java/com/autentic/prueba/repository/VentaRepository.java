package com.autentic.prueba.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.autentic.prueba.model.entities.Venta;

@Repository
public interface VentaRepository extends CrudRepository<Venta, Integer> {

}
