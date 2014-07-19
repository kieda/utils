package org.zkieda.util.string.escape;

import java.util.Arrays;
import java.util.List;

import org.zkieda.util.Requires;
import org.zkieda.util.string.tostring.ToStringParams;

public class SimplePairStringListSerializer implements StringListSerializer{    
    private static final SimplePairStringListSerializer INSTANCE
        = new SimplePairStringListSerializer();
    
    public static SimplePairStringListSerializer get(){
    	return INSTANCE;
    }
    
    @Override
    public List<String> get(String stringToSplit) {
        if(stringToSplit.length()<2) 
            throw new IndexOutOfBoundsException("Cannot split a string less than length 2!");
        
        int lowerHalf = stringToSplit.charAt(0);
        int upperHalf = stringToSplit.charAt(1);
        
        int length = (upperHalf<<16)|(lowerHalf&0xFFFF) + 2;
        if(length > stringToSplit.length())
            throw new IndexOutOfBoundsException("Expected longer string!");
        
        
        String s1 = stringToSplit.substring(2, length);
        String s2 = stringToSplit.substring(length);
        return Arrays.asList(s1, s2);
    }

    /**
     * ToStringArgs
     * 		.message(" --- ")
     * 		.vals("strings.size()")
     * 		.keys(strings.size())
     * 		.toString();
     */
    @Override
    public String put(List<String> strings) {
    	Requires.that(strings.size()==2, 
    			ToStringParams.message("This class can only serialize lists of length 2, given list of length %1$s")
	    			.params("strings.size()")
	    			.vals(strings.size()));
        return put(strings.get(0), strings.get(1));
    }
    
    
    public String put(String val1, String val2) {
        int length = val1.length();
        
        char lowerHalf = (char)(length&0xFFFF);
        char upperHalf = (char)((length>>16)&0xFFFF);
        
        return new StringBuilder(val1.length()+val2.length()+2)
            .append(lowerHalf).append(upperHalf)
            .append(val1)
            .append(val2)
            .toString();
    }
}
