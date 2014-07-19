package org.zkieda.util.primitives;

import org.zkieda.util.Requires;

/**
 * TODO do some refactoring - have dedicated classes for bit-hacks.
 * TODO divide into unsafe (nondeterministic) and safe (will check args)
 * 
 * @author zkieda
 */
public class PrimitiveUtils {
	private PrimitiveUtils(){}
	public static class Chars{
		public static String join(char separator, char... vals){
	        int needed = Requires.nonNull(vals).length - 1;
	                                //if length = 0, -1. 
	        
	        if(needed<0) return "";
	                                
	        char[] result = new char[needed + vals.length];
	        
	        //if vals.length is even, want vals.length-1
	        //otherwise we want vals.length
	        for (int i = 0; i < needed; i++) {
	            int idx = i*2;
	            result[idx] = vals[i];       
	            result[idx+1] = separator;
	        }
	        
	        //set the last one. If we already set it, the array does not change
	        result[result.length-1]=vals[needed];
	        
	        return new String(result);
	    }
	    
	    public static final char[] generateUnique(char start, final int length){
	        char[] result = new char[length];
	        for (int i = 0; i < length; i++) {
	            result[i] = start++;
	        }
	        return result;
	    }
	}
	public static class Floats {
		private Floats(){}
		
		private static final float[] YUV = {
	        0.299f,     0.587f,     0.144f, 
	       -0.14713f,  -0.2886f,    0.436f,
	        0.615f,    -0.51499f,  -0.10001f
	    };
	    
	    public static float clamp255(float in){
	        return in<0 ? 0 :
	                    in>255 ? 255 : in;
	    }
	    
	    /**
	     * if dst is null, we allocate a new array. The input and output floar 
	     * arrays will be in the range 0 .. 255.
	     * 
	     * @param src the input array in RGB color space to be converted to YUV
	     * @param dst the destination array that stores the YUV representation of
	     * {@code in}. {@code dst}, if non-null, should have length greater than or 
	     * equal to 3. 
	     * 
	     * @return the YUV representation of {@code}. If {@code dst} is null, 
	     * we allocate a new array and return it. Otherwise, we return {@code dst}.
	     * 
	     * We allow the {@code src} to be equal to the {@code dst}
	     */
	    public static float[] cRGBtoYUV(float[] src, float[] dst){
	        assert src!=null;
	        
	        if(dst == null){
	            dst = new float[3];
	        }
	        
	        assert dst.length >= 3 &&  src.length >= 3;
	        assert src[0]>=0 && src[1]>=0 && src[2]>=0;
	        
	        float i0 = src[0], i1 = src[1], i2 = src[2];
	        
	        dst[0] = clamp255(YUV[0]*i0 + YUV[1]*i1 + YUV[2]*i2);
	        dst[1] = clamp255(YUV[3]*i0 + YUV[4]*i1 + YUV[5]*i2);
	        dst[2] = clamp255(YUV[6]*i0 + YUV[7]*i1 + YUV[8]*i2);
	        
	        return dst;
	    }
	    
	    /**
	     * A basic algorithm to determine the difference in colors. Done in YUV 
	     * space for additional accuracy.
	     * 
	     * @param yuv1
	     * @param yuv2
	     * @return 
	     */
	    public static float deviationYUV(float[] yuv1, float[] yuv2){
	        
	        float d0 = yuv1[0] - yuv2[0],
	              d1 = yuv1[1] - yuv2[1],
	              d2 = yuv1[2] - yuv2[2];
	        
	        return (float)StrictMath.sqrt
	               (d0*d0 + d1*d1 + d2*d2);
	        
	    }
	    
	    public static float deviationRGB(float[] rgb1, float[] rgb2){
	        //convert to YUV for more accuracy
	        return deviationYUV(cRGBtoYUV(rgb1, null), cRGBtoYUV(rgb2, null));
	    }
	    
	    /**
	     * Converts a byte into the 0 .. 255 floating point representation of 
	     * {@code b}
	     * 
	     * @param b
	     * @return 
	     */
	    public static float byteToFloat(byte b){
	        return b&0xFF;
	    }
	    
		/**
		 * Bounds a floating point integer in the range [0,..1], inclusive. The list
		 * of cases based on f is seen below if f < 0, return 1 if f > 1, return 0
		 * if f NaN, return 1 if f +Infinity, return 1 if f -Infinity, return 0
		 * otherwise, return f
		 *
		 * @param f
		 *            an input floating number to be bounded
		 * @return an integer between 0 and 1, inclusive
		 */
		public static float bound(float f) {
			// get the integer representation
			int i = Float.floatToRawIntBits(f);

			// i is 0 if i is negative
			i = i & (~(i >> 31));

			// round top
			i = (i > 0x3f800000) ? 0x3f800000 : i;
			// return float representation
			return Float.intBitsToFloat(i);
		}
	}
	public static class Ints {
		public static byte[] split(int off, byte[] val, int i) {
			Requires.inBounds(off, 4, Requires.nonNull(val).length);
			
			val[off] = split1(i);
			val[off+1] = split2(i);
			val[off+2] = split3(i);
			val[off+3] = split4(i);
			return val;
		}
		public static byte[] split(int i) {
			return split(0, new byte[4], i);
		}

		public static byte split1(int i) {
			return (byte) ((i >> 24) & 0xFF);
		}

		public static byte split2(int i) {
			return (byte) ((i >> 16) & 0xFF);
		}

		public static byte split3(int i) {
			return (byte) ((i >> 8) & 0xFF);
		}

		public static byte split4(int i) {
			return (byte) (i & 0xFF);
		}

		public static int join(byte b1, byte b2, byte b3, byte b4) {
			return (b1 << 24) & 0xFF000000 | (b2 << 16) & 0xFF0000 | (b3 << 8)
					& 0xFF00 | (b4) & 0xFF;
		}

		public static String binaryWithSpaces(int in) {
			char[] buf = new char[32 + 3];
			for (int i = 0; i < 32 + 3; i++) {
				buf[31 + 3 - i] = (i < 8) ? ((in >> i & 1) == 1) ? '1' : '0' 
					: (i == 8) ? ' '
					: (i < 17) ? ((in >> (i - 1) & 1) == 1) ? '1' : '0'
					: (i == 17) ? ' '
					: (i < 26) ? ((in >> (i - 2) & 1) == 1) ? '1'
					: '0'
					: (i == 26) ? ' '
					: ((in >> (i - 3) & 1) == 1) ? '1'
					: '0';
				// (i%9==0)?' ' : ((in>>i&1)==1)?'1':'0';
			}
			return new String(buf);
		}
	}
}
