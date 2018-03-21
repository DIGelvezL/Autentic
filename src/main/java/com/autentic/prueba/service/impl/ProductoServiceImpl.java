package com.autentic.prueba.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentic.prueba.exception.VentasException;
import com.autentic.prueba.model.dto.ProductoDto;
import com.autentic.prueba.model.entities.Producto;
import com.autentic.prueba.repository.ProductoRepository;
import com.autentic.prueba.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired ProductoRepository productoRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<ProductoDto> getProductos() throws VentasException {
		List<Producto> productosList = (List<Producto>) productoRepository.findAll();
		
		if(Objects.nonNull(productosList) && !productosList.isEmpty()){
			return productosList.stream().map(v -> modelMapper.map(v, ProductoDto.class)).collect(Collectors.toList());
		}
		
		return new ArrayList<>();
	}

}
