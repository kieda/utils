package com.zkieda.utils.wrappers;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MapWrapper<K, V> extends ObjectWrapper implements Map<K, V> {

	public MapWrapper(Map<K, V> internal) {
		super(internal);
	}

	@Override
	protected Map<K, V> i() {
		return (Map<K, V>) super.i();
	}
	
	public int size() {
		return i().size();
	}

	public boolean isEmpty() {
		return i().isEmpty();
	}

	public boolean containsKey(Object key) {
		return i().containsKey(key);
	}

	public boolean containsValue(Object value) {
		return i().containsValue(value);
	}

	public V get(Object key) {
		return i().get(key);
	}

	public V put(K key, V value) {
		return i().put(key, value);
	}

	public V remove(Object key) {
		return i().remove(key);
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		i().putAll(m);
	}

	public void clear() {
		i().clear();
	}

	public Set<K> keySet() {
		return i().keySet();
	}
	
	public Collection<V> values() {
		return i().values();
	}

	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return i().entrySet();
	}

}
