package com.g6.nomearparametros;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AnotacaoParametro {

	public static void main(String[] args) throws Exception {
		Map<String, Object> info = new HashMap<>();
		info.put("inteiro", 13);
		info.put("numero", 23);
		info.put("string", "OK");
		info.put("texto", "NOK");

		AnotacaoParametro ap = new AnotacaoParametro();
		Method m = ap.getClass().getMethod("metodo", Integer.class, String.class);
		Parametro.invocarMetodo(m, ap, info);
	}

	public void metodo(@Param("inteiro") Integer i, @Param("texto") String s) {
		System.out.println("Parametro inteiro = " + i);
		System.out.println("Parametro texto = " + s);
	}

}
