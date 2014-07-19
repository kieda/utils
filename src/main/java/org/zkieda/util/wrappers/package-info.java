package org.zkieda.util.wrappers;

/**
 * This is a set of wrappers of collections and other classes. This is especially useful if we want to change the functionality of a class on the fly 
 * 
 * <p/> Note that in each class we have a {@code public static Mut} class which are mutable versions of the class, which include get and set methods. 
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