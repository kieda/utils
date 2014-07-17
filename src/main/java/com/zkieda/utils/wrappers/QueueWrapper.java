package com.zkieda.utils.wrappers;

import java.util.Queue;

public class QueueWrapper<T> extends CollectionWrapper<T> implements Queue<T>{
	@Override
	protected Queue<T> i() {
		return (Queue<T>)super.i();
	}
	public QueueWrapper(Queue<T> internal){
		super(internal);
	}
	
	public boolean offer(T e) {
		return i().offer(e);
	}

	public T remove() {
		return i().remove();
	}

	public T poll() {
		return i().poll();
	}

	public T element() {
		return i().element();
	}

	public T peek() {
		return i().peek();
	}
}
