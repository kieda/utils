package org.zkieda.util.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;

import org.apache.commons.lang3.ArrayUtils;
import org.zkieda.util.base.Functions;

import com.google.common.collect.Iterators;

public class SimpleCollection<T> implements Collection<T>{
	private final Function<String, Boolean> containsElem;
	private static final Function<String, Boolean> NONE = Functions.constant(false);
	private static final Function<String, Boolean> ALL = Functions.constant(true);
	
	public static <T> SimpleCollection<T> none(){
		return new SimpleCollection<T>(NONE);
	}
	
	public static <T> SimpleCollection<T> all(){
		return new SimpleCollection<T>(ALL);
	}
	
	public SimpleCollection(Function<String, Boolean> containsElem){
		this.containsElem = containsElem;
	}
	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public boolean contains(Object o) {
		return containsElem.apply(String.valueOf(o));
	}

	@Override
	public Iterator<T> iterator() {
		return Iterators.emptyIterator();
	}

	@Override
	public Object[] toArray() {
		return ArrayUtils.EMPTY_OBJECT_ARRAY;
	}

	@Override
	public <K> K[] toArray(K[] a) {
		return null;
	}

	@Override
	public boolean add(T e) {
		return true;
	}

	@Override
	public boolean remove(Object o) {
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return true;
	}

	@Override
	public void clear() {}
	
}
