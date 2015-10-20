package com.g6;

import java.lang.reflect.Method;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ArgentumTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -5308010768043709089L;

	private final List<?> lista;
	private Class<?> classe;

	public ArgentumTableModel(List<?> lista) {
		this.lista = lista;
		this.classe = lista.get(0).getClass();
	}

	public int getRowCount() {
		return lista.size();
	}

	public int getColumnCount() {
		int colunas = 0;
		for (Method metodo : classe.getDeclaredMethods()) {
			if (metodo.isAnnotationPresent(Coluna.class))
				colunas++;
		}
		return colunas;
	}

	public Object getValueAt(int linha, int coluna) {
		try {
			Object objeto = lista.get(linha);
			for (Method metodo : classe.getDeclaredMethods()) {
				if (metodo.isAnnotationPresent(Coluna.class)) {
					Coluna anotacao = metodo.getAnnotation(Coluna.class);
					if (anotacao.posicao() == coluna)
						return metodo.invoke(objeto);
				}
			}
		} catch (Exception e) {
			return "Erro";
		}
		return "";
	}
}