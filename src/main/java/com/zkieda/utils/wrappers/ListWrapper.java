package com.zkieda.utils.wrappers;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class ListWrapper<T> extends CollectionWrapper<T> implements List<T> {

	public ListWrapper(List<T> internal){
		super(internal);
	}
	
	@Override
	protected List<T> i() {
		return (List<T>)super.i();
	}
	
	public boolean addAll(int index, Collection<? extends T> c) {
		return i().addAll(index, c);
	}

	public T get(int index) {
		return i().get(index);
	}

	public T set(int index, T element) {
		return i().set(index, element);
	}

	public void add(int index, T element) {
		i().add(index, element);
	}

	public T remove(int index) {
		return i().remove(index);
	}

	public int indexOf(Object o) {
		return i().indexOf(o);
	}

	public int lastIndexOf(Object o) {
		return i().lastIndexOf(o);
	}

	public ListIterator<T> listIterator() {
		return i().listIterator();
	}

	public ListIterator<T> listIterator(int index) {
		return i().listIterator(index);
	}

	public List<T> subList(int fromIndex, int toIndex) {
		return i().subList(fromIndex, toIndex);
	}
}
