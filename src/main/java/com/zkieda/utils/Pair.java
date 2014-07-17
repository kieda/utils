package com.zkieda.utils;


/**
 * TODO temp class till we can dl a real one
 * 
 * @author zkieda
 */
public class Pair<A, B> {
	private final A first;
	private final B second; 
	
	public static <A, B> Pair<A, B> of(A first, B second){
		return new Pair(first, second);
	}
	
	public Pair(A first, B second){
		this.first = first;
		this.second = second;
	}
	public A getFirst() {
		return first;
	}
	public B getSecond() {
		return second;
	}
}
