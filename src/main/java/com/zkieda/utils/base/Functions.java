package com.zkieda.utils.base;

import java.io.Serializable;

import com.google.common.base.Function;
import com.google.common.base.Objects;

public class Functions {
	
	public static <A, B> Function<A, B> constant(B elem){
		return new ConstantFunction<A, B>(elem);
	}
	
	private static class ConstantFunction<R, E> implements Function<R, E>,
			Serializable {
		private final E value;

		public ConstantFunction(E value) {
			this.value = value;
		}

		@Override
		public E apply(R from) {
			return value;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof ConstantFunction) {
				ConstantFunction<?, ?> that = (ConstantFunction<?, ?>) obj;
				return Objects.equal(value, that.value);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return (value == null) ? 0 : value.hashCode();
		}

		@Override
		public String toString() {
			return "constant(" + value + ")";
		}

		private static final long serialVersionUID = 1;
	}
}
