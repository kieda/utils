import com.zkieda.utils.Requires;


public class Asdf {
	public static void main(String[] args) throws Exception{
		Integer mod = null;
		for (Class<?> c : new Class[]{void.class, int.class, long.class, short.class, float.class, double.class, boolean.class}) {
			if(mod==null){
				mod = c.getModifiers();
			} else{
				Requires.that(mod == c.getModifiers());
			}
		}
//		System.out.println(void.class.getMethods().length);
//		System.out.println(int.class);
	}
}
