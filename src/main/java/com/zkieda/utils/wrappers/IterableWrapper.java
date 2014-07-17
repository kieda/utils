package com.zkieda.utils.wrappers;

import java.util.Iterator;

public class IterableWrapper<T> extends ObjectWrapper implements Iterable<T> {

	@Override
	protected Iterable<T> i() {
		return (Iterable<T>)super.i();
	}
	
	public IterableWrapper(Iterable<T> internal) {
		super(internal);
	}

	public Iterator<T> iterator() {
		return i().iterator();
	}
}
