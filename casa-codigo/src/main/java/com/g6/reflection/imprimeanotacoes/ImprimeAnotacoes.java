package com.g6.reflection.imprimeanotacoes;

import com.g6.reflection.recuperaannotacao.Metadado;

@Metadado(nome = "teste", numero = 34)
// @Anotacao(String.class)
public class ImprimeAnotacoes {

	public static void main(String[] args) throws Exception {
		Imprime.imprimeAnotacoes(ImprimeAnotacoes.class);
	}

}
