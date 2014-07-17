package com.zkieda.utils.tostring;

import com.zkieda.utils.Requires;
/**
 * Example : 
 * <pre>
 * {@code
 * 	Requires.that(len >= 0, ToStringMapHelper.on("idx", "len", "size")
 * 			.message("len < 0", idx, len, size));
 * }
 * </pre>
 * 
 * @author zkieda
 */
public class ToStringMapHelper {
	private final String[] paramNames;
	
	private ToStringMapHelper(String[] paramNames){
		this.paramNames = paramNames;
	}
	public static ToStringMapHelper on(String... keys){
		Requires.nonNull(keys);
		return new ToStringMapHelper(keys);
	}
	public String message(String errorMessage, Object... vals){
		Requires.nonNull(errorMessage, vals);
		return buildMessage(new StringBuilder(errorMessage).append("; "), vals).toString();
	}
	
	public String vals(Object... vals){
		Requires.nonNull((Object)vals);
		return buildMessage(new StringBuilder(), vals).toString();
	}
	private StringBuilder buildMessage(StringBuilder builder, Object[] vals){
		builder.append('{');
		int min = Math.min(vals.length, paramNames.length);
		if(min > 0)
			builder.append(paramNames[0]).append("=").append(vals[0]);
		for(int i = 1; i < min; i++){
			builder.append(", ").append(paramNames[0]).append("=").append(vals[i]);
		}
		
		return builder.append('}');
	}
}
