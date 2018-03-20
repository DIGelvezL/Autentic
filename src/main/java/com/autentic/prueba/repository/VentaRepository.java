package com.autentic.prueba.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.autentic.prueba.model.entities.Venta;

@Repository
public interface VentaRepository extends CrudRepository<Venta, Integer> {

	@Query(value = "SELECT r FROM Reserva r JOIN r.usuario u WHERE u.cedula = :cedula ")
	public List<Venta> consultarByCedula(@Param("cedula") String cedula);
	
	@Query(value = "SELECT r FROM Reserva r JOIN r.usuario u WHERE u.cedula = :cedula AND r.fechaReserva = :fecha ")
	public List<Venta> consultarByCedulaFecha(@Param("cedula") String cedula, @Param("fecha") Date fecha);
}
