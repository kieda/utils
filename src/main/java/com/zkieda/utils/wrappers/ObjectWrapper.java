package com.zkieda.utils.wrappers;

import com.zkieda.utils.Requires;


public class ObjectWrapper {
	private final Object internal;
	protected Object i(){
		return internal;
	}
	public ObjectWrapper(Object internal){
		this.internal = Requires.nonNull(internal);
	}
	@Override
	public int hashCode() {
		return i().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return i().equals(obj);
	}
}
