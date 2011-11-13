import static org.junit.Assert.*;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.Before;

//Because the class only adds to the counter, and calls super, since since
//super is sufficently unit tested, these tests just look for the count. 

public class InstrumentedListTest {
	private InstrumentedList<String> iList = null;
	
	@Before public void setUp(){
		LinkedList stringLinkedList = new LinkedList<String>();
		iList = new InstrumentedList<String>(stringLinkedList);
	}
	
	@Test
	public void testAddE() {
		int count = iList.getAddCount();
		iList.add("one");
		assertTrue(count+1==iList.getAddCount());//Adding should increase the count by one
	}
	@Test
	public void testAddAllCollection() {
		int count = iList.getAddCount();
		Collection toAdd = new LinkedList();
		toAdd.add("one");
		toAdd.add("two");
		toAdd.add("three");
		iList.addAll(toAdd);
		assertTrue(count+toAdd.size()==iList.getAddCount());
	}
	@Test
	public void testAddIndexElement() {
		int count = iList.getAddCount();
		iList.add("one");
		iList.add("three");
		iList.add(1, "two");
		
		
		assertTrue(count+3==iList.getAddCount());//Adding should increase the count by one

	}
	@Test
	public void testAddAllIndexCollection() {
		iList.add("a");
		iList.add("b");
		iList.add("c");
		
		
		int count = iList.getAddCount();
		Collection toAdd = new LinkedList();
		toAdd.add("one");
		toAdd.add("two");
		toAdd.add("three");
		iList.addAll(2, toAdd);
		assertTrue(count+toAdd.size()==iList.getAddCount());
		
		
		
	}
	
	
	

}
