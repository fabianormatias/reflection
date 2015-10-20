package com.g6;

import java.util.Calendar;

public final class Negocio {

	private double preco;
	private int quantidade;
	private Calendar data;

	@Coluna(posicao = 0)
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Coluna(posicao = 1)
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Coluna(posicao = 2)
	public Calendar getData() {
		return (Calendar) data.clone();
	}

	public void setData(Calendar data) {
		this.data = data;
	}

}