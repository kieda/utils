package com.zkieda.utils;

import java.util.Objects;

import com.google.common.base.Preconditions;
import com.zkieda.utils.base.ArrayUtils;
import com.zkieda.utils.tostring.ToStringArgs;

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
	public static void that(boolean expr, Object errmessage){
		Preconditions.checkArgument(expr, errmessage);
	}
	
	public static void inBounds(int idx, int len, int size){
		Requires.that(len >= 0, ToStringArgs.message("len < 0")
				.params("idx", "len", "size")
				.vals(idx, len, size));
		Preconditions.checkPositionIndexes(idx, idx+len, size);
	}
	public static void index(int idx, int size){
		Preconditions.checkPositionIndex(idx, size);
	}
	public static void index(int idx1, int idx2, int size){
		Preconditions.checkPositionIndexes(idx1, idx2, size);
	}
}
