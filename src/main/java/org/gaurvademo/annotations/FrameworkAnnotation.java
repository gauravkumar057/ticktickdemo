package org.gaurvademo.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.gauravdemo.enums.CategoryType;

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotation {
	
	public String[] author();
	public CategoryType[] category();

}
