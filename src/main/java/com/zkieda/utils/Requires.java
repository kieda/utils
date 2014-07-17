package com.zkieda.utils;

import java.util.Objects;

import com.google.common.base.Preconditions;

public final class Requires {
	private Requires(){}
	public static <T> T nonNull(T e){
		return Objects.requireNonNull(e);
	}
	
	public static <T> T nonNull(T e1, Object e2){
		Objects.requireNonNull(e1); Objects.requireNonNull(e2);
		return e1;
	}
	
	public static <T> T nonNull(T e1, Object e2, Object e3){
		Objects.requireNonNull(e1); Objects.requireNonNull(e2);
		Objects.requireNonNull(e3);
		return e1;
	}
	
	public static <T> T nonNull(T e1, Object e2, Object e3, Object e4){
		Objects.requireNonNull(e1); Objects.requireNonNull(e2);
		Objects.requireNonNull(e3); Objects.requireNonNull(e4);
		return e1;
	}
	
	public static void nonNull(Object... elems){
		Objects.requireNonNull(ArrayUtils.contains(null, elems)?null:elems);
	}
	public static void that(boolean expr){
		Preconditions.checkArgument(expr);
	}
}
