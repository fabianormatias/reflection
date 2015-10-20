package com.g6.reflection.imprimeanotacoes;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class Imprime {

	public static void imprimeAnotacoes(AnnotatedElement ae) throws Exception {
		Annotation[] ans = ae.getAnnotations();
		for (Annotation a : ans) {
			Class<?> c = a.annotationType();
			System.out.println("@" + c.getName());
			for (Method m : c.getDeclaredMethods()) {
				Object o = m.invoke(a);
				System.out.println(" |->" + m.getName() + " = " + o);
			}
		}
	}

}
