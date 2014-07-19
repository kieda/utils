package org.zkieda.util.wrappers;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class ListWrapper<T> extends CollectionWrapper<T> implements List<T> {

	protected List<T> internal;
	
	public ListWrapper(List<T> internal){
		super(internal);
		this.internal = internal;
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		return internal.addAll(index, c);
	}

	@Override
	public T get(int index) {
		return internal.get(index);
	}

	@Override
	public T set(int index, T element) {
		return internal.set(index, element);
	}

	@Override
	public void add(int index, T element) {
		internal.add(index, element);
	}

	@Override
	public T remove(int index) {
		return internal.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return internal.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return internal.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator() {
		return internal.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return internal.listIterator(index);
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return internal.subList(fromIndex, toIndex);
	}
	
	public static class Mut<T> extends ListWrapper<T>{
		public Mut(List<T> internal) {
			super(internal);
		}
		public List<T> getInternal(){
			return super.internal;
		}
		public void setInternal(List<T> internal){
			super.internal = internal;
		}
	}
}
