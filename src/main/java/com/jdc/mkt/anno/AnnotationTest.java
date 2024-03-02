package com.jdc.mkt.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

public class AnnotationTest {
//	@MyAnno(value = "hi",
//			owner = Person.class,
//			gender = Type.FEMALE)
//	String name;
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		show();
	}
	
	@MyAnno(value = {"sss","kk","ll"},
			owner  = Person.class,
			gender = Type.MALE,
			data = 0,
			other = { 
					@OtherAnno(gender = Type.FEMALE),
					@OtherAnno(gender = Type.MALE)
					})
	static void show() throws NoSuchMethodException, SecurityException {
		var method = AnnotationTest.class.getDeclaredMethod("show");
		var anno = method.getDeclaredAnnotation(MyAnno.class);
		
		if(null != anno) {
			for(String n : anno.value()) {
				System.out.println(n+"\t");
			}
			System.out.println();
			System.out.println(anno.gender());
		}
		
	};
	
	
}

enum Type{
	MALE,FEMALE,OTHER
}

class Person{
	
	@SafeVarargs
	static void doSome(List<String>...list) {}
	
	@Deprecated
	void show() {
	}
	
	@Override
	public String toString() {
		return super.toString();
	}	
	
	
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface OtherAnno{
	Type gender();
}




@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
@interface MyAnno{
	// we can use
	String[] value();
		
	Class owner();
	Type gender();
	
	OtherAnno[] other();
	int data();
	
}





















