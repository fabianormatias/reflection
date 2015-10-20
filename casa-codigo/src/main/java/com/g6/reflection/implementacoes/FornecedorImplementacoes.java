package com.g6.reflection.implementacoes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FornecedorImplementacoes {

	private Map<Class<?>, Class<?>> implementacoes = new HashMap<Class<?>, Class<?>>();

	public FornecedorImplementacoes(String nomeArquivo) throws IOException, ClassNotFoundException {
		Properties p = new Properties();
		p.load(new FileInputStream(nomeArquivo));
		for (Object interf : p.keySet()) {
			Class<?> interfType = Class.forName(interf.toString());
			Class<?> implType = Class.forName(p.get(interf).toString());
			implementacoes.put(interfType, implType);
		}
	}

	public Class<?> getImplementacao(Class<?> interf) {
		return implementacoes.get(interf);
	}

	public static void main(String[] args) {
		try {
			FornecedorImplementacoes f = new FornecedorImplementacoes("implementacoes.prop");
			Class<?> impl = f.getImplementacao(DAO.class);
			System.out.println("Implementacao recuperada: " + impl.getName());
		} catch (ClassNotFoundException | IOException e) {
			throw new RuntimeException("Problema ao obter implantacoes" + e.getMessage());
		}
	}

}
