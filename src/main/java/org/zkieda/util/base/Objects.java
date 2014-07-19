package org.zkieda.util.base;

import org.apache.commons.lang3.ObjectUtils;

public class Objects {
	
	@SafeVarargs
	public static <A> A firstNonNull(A... values){
		return ObjectUtils.firstNonNull(values);
	}
	public static <A> A defaultIfNull(A first, A second){
		return ObjectUtils.defaultIfNull(first, second);
	}
	public static String toString(Object obj){
		return java.util.Objects.toString(obj);
	}
	public static String toString(Object obj, String nullDefault){
		return java.util.Objects.toString(obj, nullDefault);
	}
	public static <A> A firstNonNullThrow(A first, A second){
		return com.google.common.base.Objects.firstNonNull(first, second);
	}
	public static int hashCode(Object o){
		return java.util.Objects.hashCode(o);
	}
	public static int hash(Object... o){
		return java.util.Objects.hash(o);
	}
	public static boolean equals(Object a, Object b){
		return java.util.Objects.equals(a, b);
	}
	public static boolean deepEquals(Object a, Object b){
		return java.util.Objects.deepEquals(a, b);
	}
	public static <A> A retainIfSecondArgIsNull(A val, Object o){
        return o==null?val:null;
    }
}
