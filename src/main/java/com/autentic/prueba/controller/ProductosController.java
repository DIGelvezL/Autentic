package com.autentic.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.autentic.prueba.exception.VentasException;
import com.autentic.prueba.model.dto.ProductoDto;
import com.autentic.prueba.service.ProductoService;
import com.autentic.prueba.util.ConstantesUtil;

@RestController
@RequestMapping(ConstantesUtil.URL_API)
public class ProductosController {

	@Autowired private ProductoService productoService;
	
	@CrossOrigin
	@RequestMapping(value = ConstantesUtil.CONSULTAR_PRODUCTOS, method = RequestMethod.GET)
	public List<ProductoDto> consultarProductos() {
		List<ProductoDto> lst = null;
		try {
			lst = productoService.getProductos();
		} catch (VentasException e) {
			e.printStackTrace();
		}
		return lst;
	}
}
