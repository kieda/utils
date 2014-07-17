package com.zkieda.utils.wrappers;

import java.util.Collection;

/**
 * 
 * @param <T>
 * @author zkieda
 */
public class CollectionWrapper<T> extends IterableWrapper<T> implements Collection<T>{

	@Override
	protected Collection<T> i() {
		return (Collection<T>)super.i();
	}
	
	public CollectionWrapper(Collection<T> internal){
		super(internal);
	}
	public int size() {
		return i().size();
	}

	public boolean isEmpty() {
		return i().isEmpty();
	}

	public boolean contains(Object o) {
		return i().contains(o);
	}

	public Object[] toArray() {
		return i().toArray();
	}

	public <T> T[] toArray(T[] a) {
		return i().toArray(a);
	}

	public boolean add(T e) {
		return i().add(e);
	}

	public boolean remove(Object o) {
		return i().remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		return i().containsAll(c);
	}

	public boolean addAll(Collection<? extends T> c) {
		return i().addAll(c);
	}

	public boolean removeAll(Collection<?> c) {
		return i().removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return i().retainAll(c);
	}

	public void clear() {
		i().clear();
	}
}
