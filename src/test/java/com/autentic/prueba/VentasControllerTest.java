package com.autentic.prueba;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.autentic.prueba.controller.VentasController;
import com.autentic.prueba.model.dto.ProductoDto;
import com.autentic.prueba.model.dto.UsuarioDto;
import com.autentic.prueba.model.dto.VentaDto;
import com.autentic.prueba.model.entities.Usuario;
import com.autentic.prueba.model.response.RegistrarVentaResponse;
import com.autentic.prueba.repository.UsuarioRepository;
import com.autentic.prueba.repository.VentaRepository;
import com.autentic.prueba.service.VentasService;
import com.autentic.prueba.service.impl.VentasServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VentasControllerTest {

	VentasController ventasController = new VentasController();
	@InjectMocks VentasService ventasService = new VentasServiceImpl();
	@Mock UsuarioRepository usuarioRepository;
	@Mock VentaRepository ventaRepository;
	
	@Before
	public void main(){
		ReflectionTestUtils.setField(ventasController, "ventasService", ventasService);
		ReflectionTestUtils.setField(ventasService, "usuarioRepository", usuarioRepository);
		ReflectionTestUtils.setField(ventasService, "ventaRepository", ventaRepository);
	}
	
	@Test
	public void registrarVentaDtoNull() {
		
		RegistrarVentaResponse registrarVentaResponse = ventasController.registrarVenta(null);
		assertEquals("Error al guardar, datos incompletos", registrarVentaResponse.getRespuesta().getDescripcion());
	}
	
	@Test
	public void registrarVentaDtoNonNull() {
		Usuario arg1 = new Usuario();
		arg1.setId(1);
		arg1.setNombre("daniel");
		arg1.setApellido("gelvez");
		arg1.setCedula("123");
		
		Mockito.when(usuarioRepository.findByCedula(Mockito.anyString())).thenReturn(arg1);
		
		VentaDto ventaDto = new VentaDto();
		ventaDto.setId(null);
		ventaDto.setFechaVenta(new Date());
		
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setId(1);
		usuarioDto.setNombre("daniel");
		usuarioDto.setApellido("gelvez");
		usuarioDto.setCedula("123");
		ventaDto.setUsuario(usuarioDto);
		
		ProductoDto productoDto = new ProductoDto();
		productoDto.setId(1);
		productoDto.setNombre("Computador");
		productoDto.setValor(5900000);
		ventaDto.setProducto(productoDto);
		
		RegistrarVentaResponse registrarVentaResponse = ventasController.registrarVenta(ventaDto);
		assertEquals("OK", registrarVentaResponse.getRespuesta().getDescripcion());
	}
	
	@Test
	public void registrarVentaDtoVacio() {
		Usuario arg1 = new Usuario();
		arg1.setId(1);
		arg1.setNombre("daniel");
		arg1.setApellido("gelvez");
		arg1.setCedula("123");
		
		Mockito.when(usuarioRepository.findByCedula(Mockito.anyString())).thenReturn(arg1);
		
		VentaDto ventaDto = new VentaDto();
		
		RegistrarVentaResponse registrarVentaResponse = ventasController.registrarVenta(ventaDto);
		assertEquals("Error al guardar, datos incompletos", registrarVentaResponse.getRespuesta().getDescripcion());
	}
	
	@Test
	public void registrarVentaProductoEmpty() {
		
		Mockito.when(usuarioRepository.findByCedula(Mockito.anyString())).thenReturn(null);
		
		VentaDto ventaDto = new VentaDto();
		ventaDto.setId(null);
		ventaDto.setFechaVenta(new Date());
		
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setId(1);
		usuarioDto.setNombre("daniel");
		usuarioDto.setApellido("gelvez");
		usuarioDto.setCedula("123");
		ventaDto.setUsuario(usuarioDto);
		
		ProductoDto productoDto = new ProductoDto();
		ventaDto.setProducto(productoDto);
		
		RegistrarVentaResponse registrarVentaResponse = ventasController.registrarVenta(ventaDto);
		assertEquals("Error al guardar, datos incompletos", registrarVentaResponse.getRespuesta().getDescripcion());
	}
	
	@Test
	public void consultarVentas() {
		
		List<VentaDto> reservaDtoList = ventasController.consultarVentas();
		assertEquals(new ArrayList<>(), reservaDtoList);
	}

}
