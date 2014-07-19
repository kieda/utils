package org.zkieda.util.wrappers;

import org.zkieda.util.Requires;


public class ObjectWrapper {
	protected Object internal;
	public ObjectWrapper(Object internal){
		this.internal = Requires.nonNull(internal);
	}
	@Override
	public int hashCode() {
		return internal.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return internal.equals(obj);
	}
	public static class Mut<T> extends ObjectWrapper{
		public Mut(T internal){
			super(internal);
		}
		public void setInternal(T internal){
			super.internal = internal;
		}
		@SuppressWarnings("unchecked")
		public T getInternal(){
			return (T)super.internal;
		}
	}
}
