package org.zkieda.util.wrappers;

import java.util.Iterator;

public class IterableWrapper<T> extends ObjectWrapper implements Iterable<T> {

	protected Iterable<T> internal; 
	
	public IterableWrapper(Iterable<T> internal) {
		super(internal);
		this.internal = internal;
	}

	@Override
	public Iterator<T> iterator() {
		return internal.iterator();
	}
	public static class Mut<T> extends IterableWrapper<T>{
		public Mut(Iterable<T> internal) {
			super(internal);
		}
		
		public Iterable<T> getInternal(){
			return internal;
		}
		
		public void setInternal(Iterable<T> internal){
			super.internal = internal;
		}
	}
}
