package com.autentic.prueba.service;

import java.util.List;

import com.autentic.prueba.exception.VentasException;
import com.autentic.prueba.model.dto.ProductoDto;

public interface ProductoService {

	List<ProductoDto> getProductos() throws VentasException;
}
