package com.g6.reflection.geradormapa.comannotation;

public class Telefone {

	private String codigoPais;
	private String operadora;

	@NomePropriedade("codigoInternacional")
	public String getCodigoPais() {
		return codigoPais;
	}

	@Ignorar
	public String codigoOperadora() {
		return operadora;
	}

}
