package com.autentic.prueba.model.response;

import java.io.Serializable;

import com.autentic.prueba.model.dto.RespuestaDto;

public class RegistrarVentaResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private RespuestaDto respuesta;
	
	public RespuestaDto getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(RespuestaDto respuesta) {
		this.respuesta = respuesta;
	}
	
}
