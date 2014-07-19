package org.zkieda.util.collect;

import org.zkieda.util.Requires;

/**
 * @author zkieda
 */
public abstract class ImmutableStorage<S> implements Storage<S>{
	private static final Empty<Object> EMPTY = new Empty<>();
	
	public static <T> ImmutableStorage<T> of(){
		return (ImmutableStorage<T>)EMPTY;
	}
	
	public static <T> ImmutableStorage<T> of(T elem){
		return new Single<>(elem);
	}
	
	public static <T> ImmutableStorage<T> of(T elem1, T elem2){
		return new Stor4<T>(2, elem1, elem2, null, null);
	}
	
	public static <T> ImmutableStorage<T> of(T elem1, T elem2, T elem3){
		return new Stor4<T>(3, elem1, elem2, elem3, null);
	}
	
	public static <T> ImmutableStorage<T> of(T elem1, T elem2, T elem3, T elem4){
		return new Stor4<T>(4, elem1, elem2, elem3, elem4);
	}
	
	public static <T> ImmutableStorage<T> of(T... data){
		switch(Requires.nonNull(data).length){
			case 0: return of();
			case 1: return of(data[0]);
			case 2: return of(data[0], data[1]);
			case 3: return of(data[0], data[1], data[2]);
			case 4: return of(data[0], data[1], data[2], data[3]);
			default: return new Multi<>(data); 
		}
	}
	
	public static <T> ImmutableStorage<T> ofNonNull(T elem){
		return of(Requires.nonNull(elem));
	}
	public static <T> ImmutableStorage<T> ofNonNull(T elem1, T elem2){
		return of(Requires.nonNull(elem1), Requires.nonNull(elem2));
	}
	public static <T> ImmutableStorage<T> ofNonNull(T elem1, T elem2, T elem3){
		return of(Requires.nonNull(elem1), Requires.nonNull(elem2), Requires.nonNull(elem3));
	}
	public static <T> ImmutableStorage<T> ofNonNull(T elem1, T elem2, T elem3, T elem4){
		return of(Requires.nonNull(elem1), Requires.nonNull(elem2), Requires.nonNull(elem3), Requires.nonNull(elem4));
	}
	
	public static <T> ImmutableStorage<T> ofNonNull(T... data){
		return of(Requires.nonNullArray(data));
	}
	
	private static class Empty<S> extends ImmutableStorage<S>{
		@Override
		public int length() {
			return 0;
		}

		@Override
		public S get(int i) {
			checkIdx(i);
			return null;
		}		
	}	

	private static class Single<S> extends ImmutableStorage<S>{
		private final S obj;
		private Single(S obj){
			this.obj = obj;
		}
		@Override
		public int length() {
			return 1;
		}

		@Override
		public S get(int i) {
			checkIdx(i);
			return obj;
		}		
	}
	
	private static class Stor4<S> extends ImmutableStorage<S>{
	    private final S a;
	    private final S b;
	    private final S c;
	    private final S d;
	    private final int len;
	    
	    private Stor4(int len, S a, S b, S c, S d) {
	    	assert len <= 4;
	    	
	    	this.len = len;
	        this.a = a; this.b = b;
	        this.c = c; this.d = d;
	    }
	    @Override public final S get(int i) {
	    	checkIdx(i);
	    	
	    	switch(i){
	    		case 0: return a;
	    		case 1: return b;
	    		case 2: return c;
	    		default: return d; 
	    	}
	    }
	    
	    @Override public final int length(){return len;}
	}
	
	private static class Multi<S> extends ImmutableStorage<S>{
	    private final Object[] data;
	
	    private Multi(S... data) {
	        this.data = new Object[data.length];
	        System.arraycopy(data, 0, this.data, 0, data.length);
	    }
	    @Override public final S get(int i) {
	    	//do not need to check - will throw index out of bounds
	        return (S)data[i];
	    }
	    
	    @Override public final int length(){return data.length;}
	}
}
