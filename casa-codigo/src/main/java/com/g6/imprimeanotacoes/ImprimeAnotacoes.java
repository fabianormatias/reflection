package com.g6.imprimeanotacoes;

import com.g6.recuperaannotacao.Metadado;

@Metadado(nome = "teste", numero = 34)
// @Anotacao(String.class)
public class ImprimeAnotacoes {

	public static void main(String[] args) throws Exception {
		Imprime.imprimeAnotacoes(ImprimeAnotacoes.class);
	}

}
