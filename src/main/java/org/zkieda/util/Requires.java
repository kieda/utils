package org.zkieda.util;

import java.util.Objects;
import java.util.function.Supplier;

import org.apache.commons.lang3.ArrayUtils;
import org.zkieda.util.string.tostring.ToStringParams;

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
	
	public static <T> T[] nonNullArray(T... elems){
		return Objects.requireNonNull(ArrayUtils.contains(null, elems)?null:elems);
	}
	
	public static <T> T nonNullSupplier(T e, Supplier<String> messageSupplier){
		return Objects.requireNonNull(e, messageSupplier);
	}
	
	public static <T> T nonNullSupplier(T e1, Object e2, Supplier<String> messageSupplier){
		Objects.requireNonNull(e1, messageSupplier); 
		Objects.requireNonNull(e2, messageSupplier);
		return e1;
	}
	
	public static <T> T nonNullSupplier(T e1, Object e2, Object e3, Supplier<String> messageSupplier){
		Objects.requireNonNull(e1, messageSupplier); 
		Objects.requireNonNull(e2, messageSupplier);
		Objects.requireNonNull(e3, messageSupplier);
		return e1;
	}
	
	public static <T> T nonNullSupplier(T e1, Object e2, Object e3, Object e4, Supplier<String> messageSupplier){
		Objects.requireNonNull(e1, messageSupplier); 
		Objects.requireNonNull(e2, messageSupplier);
		Objects.requireNonNull(e3, messageSupplier); 
		Objects.requireNonNull(e4, messageSupplier);
		return e1;
	}
	
	public static void nonNullSupplier(Supplier<String> messageSupplier, Object... elems){
		Objects.requireNonNull(ArrayUtils.contains(null, elems)?null:elems, messageSupplier);
	}
	
	public static void that(boolean expr){
		if (!expr) {
			throw new IllegalArgumentException();
	    }
	}
	public static void that(boolean expr, Object errmessage){
		if (!expr) {
			throw new IllegalArgumentException(Objects.toString(errmessage));
	    }
	}
	public static void thatArg(boolean expr, String errmessage, Object... vals){
		if (!expr) {
			throw new IllegalArgumentException(errmessage==null?"null":String.format(errmessage, vals));
	    }
	}
	
	public static void thatSupplier(boolean expr, Supplier<String> messageSupplier){
		if(!expr){
			throw new IllegalArgumentException(Objects.toString(messageSupplier.get()));
		}
	}
	
	public static void inBounds(int idx, int len, int size){
		Requires.thatSupplier(len >= 0, () -> ToStringParams.message("len < 0")
				.params("idx", "len", "size")
				.vals(idx, len, size)
				.toString());
		Preconditions.checkPositionIndexes(idx, idx+len, size);
	}
	
	public static void index(int idx, int size, Object message){
		Preconditions.checkPositionIndex(idx, size, Objects.toString(message));
	}
	
	public static void index(int idx, int size){
		Preconditions.checkPositionIndex(idx, size);
	}
	
	public static void index(int idx1, int idx2, int size){
		Preconditions.checkPositionIndexes(idx1, idx2, size);
	}
	
	public static void state(boolean expr){
		Preconditions.checkState(expr);
	}
	
	public static void state(boolean expr, Object message){
		Preconditions.checkState(expr, message);
	}
	
	public static void stateSupplier(boolean expr, Supplier<String> message){
		if (!expr) {
			throw new IllegalStateException(String.valueOf(message.get()));
		}
	}
}
