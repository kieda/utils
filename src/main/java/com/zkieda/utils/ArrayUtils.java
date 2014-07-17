package com.zkieda.utils;

public final class ArrayUtils {
	private ArrayUtils(){}
	
	//TODO use apache library with this
	public static final int[] 		EMPTY_INT 		= {}; 
	public static final long[] 		EMPTY_LONG 		= {};
	public static final short[] 	EMPTY_SHORT 	= {};
	public static final byte[] 		EMPTY_BYTE  	= {};
	public static final boolean[] 	EMPTY_BOOLEAN   = {};
	public static final float[] 	EMPTY_FLOAT 	= {};
	public static final double[] 	EMPTY_DOUBLE 	= {};
	public static final Object[] 	EMPTY_OBJECT 	= {};
	
	
	/**
	 * @param elem the element we are searching for
	 * @param elems 
	 * @return
	 */
	public static boolean contains(Object elem, Object... elems){
		if(elems==null) return false;
		if(elem==null){
			for(Object o : elems)
				if(elem == o) return true;
		} else{
			for(Object o : elems)
				if(elem.equals(o)) return true;
		}
		return false;
	}
}
