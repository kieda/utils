package com.zkieda.utils.tostring;

import java.util.Formatter;

import com.zkieda.utils.Requires;

/**
 * Note that this 
 * ToStringArgs
 * 		.message(" --- ")
 * 		.vals("strings.size()")
 * 		.keys(strings.size())
 * 		.toString();
 */
public class ToStringArgs {
	private String[] keys;
	private Object[] vals;
	private String value = null;
	private String message;
	
	private ToStringArgs(String message){
		this.message = message;
	}
	
	public static ToStringArgs message(String message){
		Requires.nonNull(message);
		return new ToStringArgs(message);
	}
	
	public static ToStringArgs get(){
		return new ToStringArgs(null);
	}
	
	public ToStringArgs params(String... keys){
		if(keys != null) Requires.nonNull(keys);
		this.keys = keys;
		return this;
	}
	
	public ToStringArgs vals(Object... vals){
		this.vals = vals;
		return this;
	}
	
	@Override
	public String toString(){
		if(value == null) {
			StringBuilder builder = new StringBuilder();
			Formatter format = new Formatter(builder);
			
			if(message!=null) format.format(message, vals);
			value = buildMessage(builder).toString();
			
			keys = null;
			vals = null;
			message = null;
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
