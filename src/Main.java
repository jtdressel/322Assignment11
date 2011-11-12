import java.sql.Date;
import java.util.Set;
import java.util.HashSet;

/**
 * @author James Dressel
 * This is a test class (in addition to the junit tests). Its purpose is for me to quickly
 * run a test on the code, when I'm conceptualizing something. (For instance, when I want 
 * to test how the set API works, I'll just write a few lines of code here.) There should 
 * not be much of value in this file. 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> s = new InstrumentedSet<String>(new HashSet<String>(4));
		InstrumentedSet<String> i = (InstrumentedSet<String>)s;
		s.add("test");
		
		
		i.add("lul");
		
		
		
		System.out.println(s.toString());
		System.out.println(i.getAddCount());
	}

}