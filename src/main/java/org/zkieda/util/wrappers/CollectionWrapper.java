package org.zkieda.util.wrappers;

import java.util.Collection;

/**
 * 
 * @param <T>
 * @author zkieda
 */
public class CollectionWrapper<T> extends IterableWrapper<T> implements Collection<T>{
	protected Collection<T> internal;
	public CollectionWrapper(Collection<T> internal){
		super(internal);
		this.internal = internal;
	}
	
	@Override
	public int size() {
		return internal.size();
	}

	@Override
	public boolean isEmpty() {
		return internal.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return internal.contains(o);
	}

	@Override
	public Object[] toArray() {
		return internal.toArray();
	}

	@Override
	public <K> K[] toArray(K[] a) {
		return internal.toArray(a);
	}

	@Override
	public boolean add(T e) {
		return internal.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return internal.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return internal.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return internal.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return internal.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return internal.retainAll(c);
	}

	@Override
	public void clear() {
		internal.clear();
	}
	
	public static class Mut<T> extends CollectionWrapper<T>{
		public Mut(Collection<T> internal) {
			super(internal);
		}
		public Collection<T> getInternal(){
			return internal;
		}
		public Collection<T> setInternal(Collection<T> internal){
			return super.internal = internal;
		}
	}
}
