package com.autentic.prueba.model.response;

import java.io.Serializable;

import com.autentic.prueba.model.dto.RespuestaDto;

public class RegistrarVentaResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private RespuestaDto respuesta;
	private Integer idFactura;
	private String lugarDespacho;
	private double valor;
	
	public RespuestaDto getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(RespuestaDto respuesta) {
		this.respuesta = respuesta;
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
