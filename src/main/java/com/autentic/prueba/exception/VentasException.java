package com.autentic.prueba.exception;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VentasException extends Exception {

	private static final Logger log = LoggerFactory.getLogger(VentasException.class);
	
	private static final long serialVersionUID = 1L;

	private final String mensajeTecnico;
	private final String traza;
	
	public VentasException(Throwable cause) {
		super(cause);
		this.mensajeTecnico = cause.getMessage();
		this.traza = Arrays.toString(cause.getStackTrace());
	}
	
	public void assemblerErrorLog() {
		log.error(this.mensajeTecnico, this.traza);
	}
}
