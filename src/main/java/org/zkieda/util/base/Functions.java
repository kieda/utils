package org.zkieda.util.base;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import org.zkieda.util.Requires;

/**
 * remake of the google Functions for java8 and for some additional functionality (get it?)
 * 
 * 
 * 
 * @author zkieda
 */
public class Functions {
	private Functions(){}
	
    public static <T> UnaryOperator<T> identity(){
    	return t -> t;
    }
	
	public static <A, B> Function<A, B> constant(final B elem){
		return t -> elem;
	}
	public static <A, B> Function<A, B> forSupplier(Supplier<B> supplier){
		return a -> supplier.get();
	}
	public static <A> Function<A, Boolean> forPredicate(Predicate<A> predicate){
		return predicate::test;
	}
	public static <K, V> Function<K, V> forMap(final Map<K, V> map){
		return k -> {
			V result = map.get(k);
			Requires.thatArg(result != null || map.containsKey(k), 
					"Key '%s' not present in map", k);
			return result;
		};
	}
	public static <K, V> Function<K, V> forMapWithDefault(final Map<K, V> map, final V defaultVal){
		return k -> {
			final V result = map.get(k);
			return (result != null || map.containsKey(k)) ? result : defaultVal; 
		};
	}
	public static <K, V> Function<K, V> forMapNullDefault(Map<K, V> map){
		return map::get;
	}
}
