package com.g6.reflection.performance;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.g6.reflection.geradormapa.comannotation.Ignorar;
import com.g6.reflection.geradormapa.comannotation.NomePropriedade;

public class GeradorMapaPerformance {

	private Map<String, Method> propriedades = new HashMap<String, Method>();
	private Class<?> classe;

	public GeradorMapaPerformance(Class<?> classe) {
		this.classe = classe;
		for (Method m : classe.getMethods()) {
			try {
				if (isGetter(m)) {
					String propriedade = null;
					if (m.isAnnotationPresent(NomePropriedade.class)) {
						propriedade = m.getAnnotation(NomePropriedade.class).value();
					} else {
						propriedade = deGetterParaPropriedade(m.getName());
					}
					propriedades.put(propriedade, m);
				}
			} catch (Exception e) {
				throw new RuntimeException("Problema ao gerar o mapa" + e);
			}
		}
	}

	public Map<String, Object> gerarMapa(Object o) {
		if (!classe.isInstance(o)) {
			throw new RuntimeException("O objeto não é da classe " + classe.getName());
		}
		Map<String, Object> mapa = new HashMap<String, Object>();
		for (String propriedade : propriedades.keySet()) {
			try {
				Method m = propriedades.get(propriedade);
				Object valor = m.invoke(o);
				mapa.put(propriedade, valor);
			} catch (Exception e) {
				throw new RuntimeException("Problema ao gerar o mapa" + e);
			}
		}
		return mapa;
	}
	
	private static boolean isGetter(Method m) {
		return m.getName().startsWith("get") && m.getReturnType() != void.class && 
			   m.getParameterTypes().length == 0 && m.isAnnotationPresent(Ignorar.class);
	}

	private static String deGetterParaPropriedade(String nomeGetter) {
		StringBuffer retorno = new StringBuffer();
		retorno.append(nomeGetter.substring(3, 4).toLowerCase());
		retorno.append(nomeGetter.substring(4));
		return retorno.toString();
	}

}
