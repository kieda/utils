package org.zkieda.util.collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.google.common.collect.Lists;

public class CollectionUtils {
	/**
	 * does NOT copy the internal values. Returns null if keys or values is null
	 *
	 * if keys.length != values.length we return a map that is of maximum size
	 * (keys.length > values.length) ? keys.length : values.length
	 */
	public static <K, V> HashMap<K, V> newHashMap(K[] keys, V[] values) {
		if (keys == null || values == null)
			return null;
		final int max = (keys.length > values.length) ? keys.length
				: values.length;
		
		HashMap<K, V> ret = new HashMap<>(max*2);


		assert max <= keys.length && max <= values.length;

		for (int i = 0; i < max; i++) {
			ret.put(keys[i], values[i]);
		}

		return ret;
	}
	public static <S> HashSet<S> newHashSet(S... values){
		if(values==null) return null;
        HashSet<S> temp = new HashSet<S>(values.length);
        for(int i = 0; i <values.length; i++){
            temp.add(values[i]);
        }
        return temp;
    }
	
	public static <S> ArrayList<S> newArrayList(S... values){
		return Lists.newArrayList(values);
    }
	
	public static <S> S[] toArray(S... vals){
		return vals;
    }
    
}
