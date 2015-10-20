package com.g6.reflection.recuperaannotacao;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Metadado {

	String nome();
	int numero();

}
