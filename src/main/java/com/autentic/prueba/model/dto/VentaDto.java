package com.autentic.prueba.model.dto;

import java.io.Serializable;
import java.util.Date;

public class VentaDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer cantidad;
	private Integer idPreventa;
	private Integer idFactura;
	private String lugarDespacho;
	private Date fechaVenta;
	private UsuarioDto usuario;
	private ProductoDto producto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getIdPreventa() {
		return idPreventa;
	}
	public void setIdPreventa(Integer idPreventa) {
		this.idPreventa = idPreventa;
	}
	public Integer getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}
	public String getLugarDespacho() {
		return lugarDespacho;
	}
	public void setLugarDespacho(String lugarDespacho) {
		this.lugarDespacho = lugarDespacho;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public UsuarioDto getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}
	public ProductoDto getProducto() {
		return producto;
	}
	public void setProducto(ProductoDto producto) {
		this.producto = producto;
	}
	
}
