package org.zkieda.util.wrappers;

import java.util.Queue;

public class QueueWrapper<T> extends CollectionWrapper<T> implements Queue<T>{
	protected Queue<T> internal;
	public QueueWrapper(Queue<T> internal){
		super(internal);
		this.internal = (Queue<T>)super.internal;
	}
	
	@Override
	public boolean offer(T e) {
		return internal.offer(e);
	}

	@Override
	public T remove() {
		return internal.remove();
	}

	@Override
	public T poll() {
		return internal.poll();
	}

	@Override
	public T element() {
		return internal.element();
	}

	@Override
	public T peek() {
		return internal.peek();
	}
	
	public static class Mut<T> extends QueueWrapper<T>{
		public Mut(Queue<T> internal) {
			super(internal);
		}
		public Queue<T> getInternal(){
			return super.internal;
		}
		public void setInternal(Queue<T> internal){
			super.internal = internal;
		}
	}
}
