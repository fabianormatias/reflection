package com.g6.geradormapa.comannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface NomePropriedade {

	String value();

}
