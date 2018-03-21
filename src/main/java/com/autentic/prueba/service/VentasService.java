package com.autentic.prueba.service;

import java.util.List;

import com.autentic.prueba.exception.VentasException;
import com.autentic.prueba.model.dto.VentaDto;
import com.autentic.prueba.model.response.RegistrarVentaResponse;

public interface VentasService {

	RegistrarVentaResponse registrarVenta(VentaDto ventaDto) throws VentasException;
	
	List<VentaDto> consultarVentas() throws VentasException;
}
