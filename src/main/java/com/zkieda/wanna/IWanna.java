package com.zkieda.wanna;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * An annotation for declaring use cases for some part of java code. 
 * 
 * If used in classes in key points, we will allow documentation to be easily searchable. 
 * 
 * 
 * TODO : find out a syntax that a person could use for documenting to improve the searchability.
 * IDEA : "This is my use case with an *important* keyword and *important keyphrase*"
 * IDEA : "This is my [use case, documentation] with different re[prasing, wordings]"
 * IDEA BETTER : just have it in javadoc, then eclipse could make it easier
 * 
 * @iwanna {
 * 		document a use case that is searchable
 * 		document with putting \sspaces\ttabs\nnew lines explicitly
 * }
 * @author zkieda
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE, ElementType.PACKAGE, ElementType.ANNOTATION_TYPE})
@IWanna("document a use case that is searchable")
public @interface IWanna {
	//the identifier that is local to the class. When we set
	public String[] value();
}
