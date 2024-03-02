package com.jdc.mkt.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotatiionTest {
//	@MyAnno
	String name;
	
	@MyAnno(value = "String",age = 23)
	void show() {}
	
	
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnno{
	String value();
	int age();
}
