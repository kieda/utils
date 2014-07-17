package com.zkieda.utils.wrappers;

/**
 * This is a set of wrappers of collections and other classes. This is especially useful if we want to change the functionality of a class on the fly 
 * 
 * @Example
 * <pre>
 * {@Code
 * 		public Set<T> modify(Set<T> other) {
 * 			return new SetWrapper(other) {
 * 				public boolean contains(Object o){
 * 					if(o == null) throw new NullPointerException();
 * 					return super.contains(o);
 * 				} 
 * 			}
 * 		}
 * }
 * </pre>
 */