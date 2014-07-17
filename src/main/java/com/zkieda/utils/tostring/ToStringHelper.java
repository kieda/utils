package com.zkieda.utils.tostring;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.zkieda.utils.Pair;
import com.zkieda.utils.collect.SimpleCollect;

/**
 * Reflection supporting to string builder. We also support adding methods and fields with the values
 * {@link ToString} 
 * 
 * Todo build this and call it good
 * 
 * @author zkieda
 */
public class ToStringHelper {
	private ToStringHelper(){}
	public static final String DEFAULT_SEPARATOR = "=";
	
	//we will require that all 
	public static final Collection<String> ALL_COLLECTION = SimpleCollect.all();
	public static final Collection<String> NONE_COLLECTION = SimpleCollect.none();
	
	public static List<String> defaultJoin(String key, String value){
		return ImmutableList.of(key, DEFAULT_SEPARATOR, value);
	}
	
	//default.
	public static final Function<Pair<String, String>, List<String>> DEFAULT = new Function<Pair<String,String>, List<String>>() {
		@Override
		public List<String> apply(Pair<String, String> input) {
			return defaultJoin(input.getFirst(), input.getSecond());
		}
	};
	
	public ToStringHelper make(){
		return new ToStringHelper();
	}
	public ToStringHelper make(Class<?> val){
		return new ToStringHelper();
	}
	
	public ToStringHelper unionClass(Class<?> c){
		return this;
	}
	
	public ToStringHelper intersectClass(Class<?> c){
		return this;
	}
	
	public ToStringHelper subtractClass(Class<?> c){
		return this;
	}
	
	/**
	 * adds a key that an implementor can use
	 * @param keyName
	 * @return
	 */
	public ToStringHelper addKey(String keyName){
		return this;
	}
	
	public ToStringHelper addMethod(String methodName){
		return this;
	}
	public ToStringHelper omitMethod(String methodName){
		return this;
	}
	
	/**
	 * 
	 * @param methodPattern 
	 * @return
	 */
	public ToStringHelper addMethod(Pattern methodPattern){
		
		return this;
	}
	public ToStringHelper omitMethod(Pattern methodPattern){
		return this;
	}
	
	public ToStringHelper addField(String fieldName){
		return this;
	}
	public ToStringHelper omitField(String fieldName){
		return this;
	}
	
	public ToStringHelper addFields(Pattern fieldPattern){
		return this;
	}
	public ToStringHelper omitFields(Pattern fieldPattern){
		return this;
	}
	
	public ToStringHelper useAnnotation(boolean t){
		return this;
	}
	
	public ToStringHelper useNullValues(boolean t){
		return this;
	}
	
	/**
	 * Function : (key : String, val : String) -> List<String>
	 * Where key is the method name, field name, or other qualified name,
	 * @param function 
	 * @return
	 */
	public ToStringHelper withKeyValProcessor(Function<Pair<String, String>, List<String>> function){
		return this;
	}
	
	/**
	 * @param function modifies the 
	 * @return
	 */
	public ToStringHelper withValProcessor(final Function<String, String> function){
		return withKeyValProcessor(new Function<Pair<String,String>, List<String>>() {
			@Override
			public List<String> apply(Pair<String, String> input) {
				return defaultJoin(input.getFirst(), function.apply(input.getSecond()));
			}
		});
	}
	
	public String build(){
		return "";
	}
}	
//the class that converts the class into a string given the data here
class ToStringer{
	private List<List<String>> stringedValues;
	
	public ToStringer(
			//transmorgifier function
			Function<Pair<String, String>, List<String>> function,
			
			//for selecting fields
			Function<Field, Boolean> fieldSelector,
			
			//for selecting methods
			Function<Method, Boolean> methodSelector, 
			
			//list of required names
			Collection<String> names){
		
	}
	
	public String toString(Object target){
		return null;
	}
}
