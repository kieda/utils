package com.zkieda.utils.tostring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Used in conjunction with {@link ToStringHelper}. Fields and no-arg methods 
 * annotated by this field are added to the string value. 
 *  
 * @author zkieda
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ToString {}
