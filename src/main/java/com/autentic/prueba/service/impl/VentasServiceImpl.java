package com.autentic.prueba.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentic.prueba.exception.VentasException;
import com.autentic.prueba.model.dto.RespuestaDto;
import com.autentic.prueba.model.dto.VentaDto;
import com.autentic.prueba.model.entities.Usuario;
import com.autentic.prueba.model.entities.Venta;
import com.autentic.prueba.model.response.RegistrarVentaResponse;
import com.autentic.prueba.repository.UsuarioRepository;
import com.autentic.prueba.repository.VentaRepository;
import com.autentic.prueba.service.VentasService;

@Service
public class VentasServiceImpl implements VentasService {
	
	@Autowired UsuarioRepository usuarioRepository;
	@Autowired VentaRepository ventaRepository;
	
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public RegistrarVentaResponse registrarVenta(VentaDto ventaDto) throws VentasException {
		RegistrarVentaResponse registrarVentaResponse = new RegistrarVentaResponse();
		
		if(Objects.nonNull(ventaDto) && Objects.nonNull(ventaDto.getUsuario()) && Objects.nonNull(ventaDto.getProducto().getId())){
			Venta venta = modelMapper.map(ventaDto, Venta.class);
			Usuario usuario = usuarioRepository.findByCedula(venta.getUsuario().getCedula());
			
			if(Objects.nonNull(usuario)){
				venta.setUsuario(usuario);
				ventaRepository.save(venta);
			}else{
				usuarioRepository.save(venta.getUsuario());
				ventaRepository.save(venta);
			}
			
			dtoAssemblerRespuestaSucces(registrarVentaResponse);
		}else{
			dtoAssemblerRespuestaError(registrarVentaResponse);
		}
		
		return registrarVentaResponse;
	}
	
	private void dtoAssemblerRespuestaSucces(RegistrarVentaResponse registrarVentaResponse) {
		RespuestaDto respuesta = new RespuestaDto();
		respuesta.setCodigo(0);
		respuesta.setDescripcion("OK");
		registrarVentaResponse.setRespuesta(respuesta);
	}
	
	private void dtoAssemblerRespuestaError(RegistrarVentaResponse registrarVentaResponse) {
		RespuestaDto respuesta = new RespuestaDto();
		respuesta.setCodigo(8000);
		respuesta.setDescripcion("Error al guardar, datos incompletos");
		registrarVentaResponse.setRespuesta(respuesta);
	}

	@Override
	public List<VentaDto> consultarVentas() throws VentasException {
		List<Venta> ventas = (List<Venta>) ventaRepository.findAll();
		
		if(Objects.nonNull(ventas) && !ventas.isEmpty()){
			return ventas.stream().map(r -> modelMapper.map(r, VentaDto.class)).collect(Collectors.toList());
		}
		
		return new ArrayList<>();
	}

}
