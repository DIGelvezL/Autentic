package com.autentic.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.autentic.prueba.exception.VentasException;
import com.autentic.prueba.model.dto.VentaDto;
import com.autentic.prueba.model.response.RegistrarVentaResponse;
import com.autentic.prueba.service.VentasService;
import com.autentic.prueba.util.ConstantesUtil;

@RestController
@RequestMapping(ConstantesUtil.URL_API)
public class VentasController {

	@Autowired private VentasService ventasService;
	
	@CrossOrigin
	@RequestMapping(value = ConstantesUtil.REGISTRAR_VENTA, method = RequestMethod.POST, 
			consumes=ConstantesUtil.APPLICATION_JSON,produces = ConstantesUtil.APPLICATION_JSON)
	@ResponseBody
	public RegistrarVentaResponse registrarVenta(@RequestBody VentaDto ventaDto) {
		RegistrarVentaResponse registrarVentaResponse = null;
		try {
			registrarVentaResponse = ventasService.registrarVenta(ventaDto);
		} catch (VentasException e) {
			VentasException exception = new VentasException(e);
			exception.assemblerErrorLog();
		}
		return registrarVentaResponse;
	}
	
	@CrossOrigin
	@RequestMapping(value = ConstantesUtil.CONSULTAR_VENTAS, method = RequestMethod.GET)
	public List<VentaDto> consultarVentas() {
		List<VentaDto> reservaDtoList = null;
		try {
			reservaDtoList = ventasService.consultarVentas();
		} catch (VentasException e) {
			VentasException exception = new VentasException(e);
			exception.assemblerErrorLog();
		}
		return reservaDtoList;
	}
}
