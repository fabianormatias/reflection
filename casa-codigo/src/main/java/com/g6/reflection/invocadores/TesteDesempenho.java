package com.g6.reflection.invocadores;

public class TesteDesempenho {

	public static void main(String[] args) {
		double normal = executaTeste(new InvocadorNormal());
		double reflection = executaTeste(new InvocadorReflexao());
		System.out.println((reflection / normal) + " vezes mais que o normal");
		double reflectionCache = executaTeste(new InvocadorReflexaoCache());
		System.out.println((reflectionCache / normal) + " vezes mais que o normal");
	}

	private static double executaTeste(InvocadorMetodo invoc) {
		long nano = System.nanoTime();
		invoc.invocarMetodo(100000);
		String nomeClasse = invoc.getClass().getName();
		long diferenca = System.nanoTime() - nano;
		System.out.println("A classe " + nomeClasse + " demorou " + diferenca + " nano segundos");
		return diferenca;
	}

}
