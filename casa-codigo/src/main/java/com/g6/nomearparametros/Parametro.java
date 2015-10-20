package com.g6.nomearparametros;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;

public class Parametro {

	public static Object invocarMetodo(Method m, Object obj, Map<String, Object> info) throws Exception {
		Annotation[][] paramAnnot = m.getParameterAnnotations();
		Object[] paramValues = new Object[paramAnnot.length];
		for (int i = 0; i < paramValues.length; i++) {
			String name = getNomeParametro(paramAnnot[i]);
			paramValues[i] = info.get(name);
		}
		return m.invoke(obj, paramValues);
	}

	private static String getNomeParametro(Annotation[] ans) {
		for (Annotation annotation : ans) {
			if (annotation instanceof Param) {
				return ((Param) annotation).value();
			}
		}
		throw new RuntimeException("Anotação @Param não encontrada.");
	}

}