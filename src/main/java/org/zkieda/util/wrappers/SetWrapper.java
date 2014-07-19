package org.zkieda.util.wrappers;

import java.util.Set;

public class SetWrapper<T> extends CollectionWrapper<T> implements Set<T>{
	protected Set<T> internal;
	public SetWrapper(Set<T> internal) {
		super(internal);
		this.internal = internal;
	}
	public static class Mut<T> extends SetWrapper<T>{
		public Mut(Set<T> internal) {
			super(internal);
		}
		public Set<T> getInternal(){
			return super.internal;
		}
		public void setInternal(Set<T> internal){
			super.internal = internal;
		}
	}
}
