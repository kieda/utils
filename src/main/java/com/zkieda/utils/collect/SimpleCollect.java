package com.zkieda.utils.collect;

import java.util.Collection;
import java.util.Iterator;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.zkieda.utils.base.ArrayUtils;
import com.zkieda.utils.base.Functions;

public class SimpleCollect<T> implements Collection<T>{
	private final Function<String, Boolean> containsElem;
	private static final Function<String, Boolean> NONE = Functions.constant(false);
	private static final Function<String, Boolean> ALL = Functions.constant(true);
	
	public static <T> SimpleCollect<T> none(){
		return new SimpleCollect<T>(NONE);
	}
	
	public static <T> SimpleCollect<T> all(){
		return new SimpleCollect<T>(ALL);
	}
	
	public SimpleCollect(Function<String, Boolean> containsElem){
		this.containsElem = containsElem;
	}
	public int size() {
		return 0;
	}

	public boolean isEmpty() {
		return true;
	}

	public boolean contains(Object o) {
		return containsElem.apply(String.valueOf(o));
	}

	public Iterator<T> iterator() {
		return Iterators.emptyIterator();
	}

	public Object[] toArray() {
		return ArrayUtils.EMPTY_OBJECT;
	}

	public <T> T[] toArray(T[] a) {
		return null;
	}

	public boolean add(T e) {
		return true;
	}

	public boolean remove(Object o) {
		return true;
	}

	public boolean containsAll(Collection<?> c) {
		return true;
	}

	public boolean addAll(Collection<? extends T> c) {
		return true;
	}

	public boolean removeAll(Collection<?> c) {
		return true;
	}

	public boolean retainAll(Collection<?> c) {
		return true;
	}

	public void clear() {}
	
}
