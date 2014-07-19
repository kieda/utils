package org.zkieda.util.string.escape;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.zkieda.util.string.escape.SingleCharDescaperTest.descaperTests;
import static org.zkieda.util.string.escape.SingleCharDescaperTest.escapeChar;
import static org.zkieda.util.string.escape.SingleCharDescaperTest.testEscapeChars;
import static org.zkieda.util.string.escape.SingleCharDescaperTest.testEscapeSingleChars;
import static org.zkieda.util.string.escape.SingleCharDescaperTest.testEscapeStrings;

import org.junit.Before;
import org.junit.Test;

/**
 * Test {@link SingleCharEscaperDescaper}
 * @author zkieda
 * @since 180
 */
public class SingleCharEscaperDescaperTest {
    EscaperDescaper[] testCases; 
    SingleCharEscaperDescaper scf;
    
    @Before
    public void init(){
       scf =  new SingleCharEscaperDescaper(escapeChar);
       
       testCases = new EscaperDescaper[
           testEscapeChars.length 
         + testEscapeStrings.length
         + testEscapeSingleChars.length
         + 1];
       
       testCases[0] = scf.apply();
       
       int i = 1;
       
       for(char escapeChar : testEscapeSingleChars)
           testCases[i++] = scf.apply(escapeChar);
       for(char[] escapeChars : testEscapeChars)
           testCases[i++] = scf.apply(escapeChars);
       for(String specialChars : testEscapeStrings)
           testCases[i++] = scf.apply(specialChars);
    }

    @Test
    public void testApply() {
        for(EscaperDescaper e : testCases){
            assertNotNull(e);
            assertNotNull(e.asFunction());
            assertNotNull(e.asReverseFunction());
        }
    }
    
    @Test
    public void testEscaperDescaper() {
        int i = 0;
        for(EscaperDescaper e : testCases){
            for(String[] descaperTest : descaperTests[i]){
                //[1] : correct result
                //[0] : to escape
                assertEquals(descaperTest[1], e.escape(descaperTest[0]));
                assertEquals(descaperTest[0], e.descape(descaperTest[1]));
                assertEquals(descaperTest[0], e.descape(e.escape(descaperTest[0])));
            }
            i++;
        }
    }

}
