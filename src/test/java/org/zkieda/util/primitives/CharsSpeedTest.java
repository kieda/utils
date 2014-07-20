package org.zkieda.util.primitives;
import static org.zkieda.util.primitives.PrimitiveUtils.Chars.*;

public class CharsSpeedTest {
	public static final boolean GOOG = true;
	public static final int TRIALS = 100;
	
    public static void main(String[] args) throws Exception{
        
        //jvm warm up
        Thread.sleep(10000);
        
        //see how me vs the googs stack up
        char[] chars10_000 = generateUnique((char)0, 10_000);
        
        //jvm warm up
        Thread.sleep(10000);
        
        long total = 0;
        for (int i = 0; i < TRIALS; i++) {
            long time = System.nanoTime();
            
            if(GOOG){
                com.google.common.primitives.Chars.join("|", chars10_000);
            }else{
                join('|', chars10_000);
            }
            
            time = System.nanoTime() - time;
            total += time;
            System.out.println("trial "+i+" time "+time);
        }
        System.out.println("total : "+total);
        System.out.println("avg : "+(double)total/(double)TRIALS);
        
        //          total,       avg,  trial 0,  trial 1, trial 99
        //ME   : 17575029, 175750.29,  6399127,   259914,    41925
        //GOOG : 33495093, 334950.93, 13437859,  2456392,   105824
    }
}
