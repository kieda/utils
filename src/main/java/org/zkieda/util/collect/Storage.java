package org.zkieda.util.collect;

import java.util.Iterator;

import org.zkieda.util.Requires;


/**
 * represents an item which has storage at some indices
 * 
 * @author zkieda
 */
public interface Storage<S> extends Iterable<S>{
	int length();
    S get(int i);
    
    @Override
	default Iterator<S> iterator(){
    	return new Iterator<S>() {
    		private int pos = 0;
			@Override
			public boolean hasNext() {
				return pos < length();
			}

			@Override
			public S next() {
				return get(pos++);
			}
		};
    }
    
    default void checkIdx(int idx){
    	Requires.index(idx, length());
    }
}