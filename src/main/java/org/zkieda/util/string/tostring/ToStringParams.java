package org.zkieda.util.string.tostring;

import java.util.Formatter;

import org.zkieda.util.Requires;

/**
 * Note that this 
 * ToStringArgs
 * 		.message(" --- ")
 * 		.vals("strings.size()")
 * 		.keys(strings.size())
 * 		.toString();
 */
public class ToStringParams {
	private String[] keys;
	private Object[] vals;
	private String value = null;
	private String message;
	
	private ToStringParams(String message){
		this.message = message;
	}
	
	public static ToStringParams message(String message){
		Requires.nonNull(message);
		return new ToStringParams(message);
	}
	
	public static ToStringParams get(){
		return new ToStringParams(null);
	}
	
	public ToStringParams params(String... keys){
		if(keys != null) Requires.nonNullArray(keys);
		this.keys = keys;
		return this;
	}
	
	public ToStringParams vals(Object... vals){
		this.vals = vals;
		return this;
	}
	
	@Override
	public String toString(){
		if(value == null) {
			StringBuilder builder = new StringBuilder();
			try(Formatter format = new Formatter(builder)){
				if(message!=null) format.format(message, vals);
				value = buildMessage(builder).toString();
			} finally{
				keys = null;
				vals = null;
				message = null;
			}
		}
		return value;
	}
	
	private StringBuilder buildMessage(StringBuilder builder){
		if(keys==null||vals==null) return builder;
		
		builder.append('{');
		int min = Math.min(vals.length, keys.length);
		if(min > 0)
			builder.append(keys[0]).append("=").append(vals[0]);
		
		for(int i = 1; i < min; i++){
			builder.append(", ").append(keys[0]).append("=").append(vals[i]);
		}
		
		return builder.append('}');
	}
}
