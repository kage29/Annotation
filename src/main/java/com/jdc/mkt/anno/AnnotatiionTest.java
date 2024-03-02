package com.jdc.mkt.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotatiionTest {
	@MyAnno("hi")
	String name;
	
	@MyAnno({"sss","kk","ll"})
	void show() {};
	
	
}


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
@interface MyAnno{
	String[] value();
	
}
