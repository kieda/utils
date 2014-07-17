package com.zkieda.utils.wrappers;

import java.util.Collection;
import java.util.Set;

public class SetWrapper<T> extends CollectionWrapper<T> implements Set<T>{

	@Override
	protected Set<T> i() {
		return (Set<T>)super.i();
	}
	
	public SetWrapper(Set<T> internal) {
		super(internal);
	}

	@Override
	public boolean add(T e) {
		return i().add(e);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return i().addAll(c);
	}
}
