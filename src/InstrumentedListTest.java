import static org.junit.Assert.*;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.Before;

//Because the class only adds to the counter, and calls super, since since
//super is sufficently unit tested, these tests just look for the count. 

public class InstrumentedListTest {
	private InstrumentedList<String> iList = null;
	/**
	 * Prepares a n InstrumentedList object used in many of the tests. 
	 */
	@Before public void setUp(){
		LinkedList stringLinkedList = new LinkedList<String>();
		iList = new InstrumentedList<String>(stringLinkedList);
	}
	/**
	 * Adds an element, and tests to see that the count has been increased. 
	 */
	@Test
	public void testAddE() {
		int count = iList.getAddCount();
		iList.add("one");
		assertTrue(count+1==iList.getAddCount());//Adding should increase the count by one
	}
	/**
	 * Adds several elements, and tests to see that the count has been increased.
	 */
	@Test
	public void testAddAllCollection() {
		int count = iList.getAddCount();
		Collection<String> toAdd = new LinkedList<String>();
		toAdd.add("one");
		toAdd.add("two");
		toAdd.add("three");
		iList.addAll(toAdd);
		assertTrue(count+toAdd.size()==iList.getAddCount());
	}
	/**
	 * Adds an element at a position and tests the count to see if it was increased.
	 */
	@Test
	public void testAddIndexElement() {
		int count = iList.getAddCount();
		iList.add("one");
		iList.add("three");
		iList.add(1, "two");
		assertTrue(count+3==iList.getAddCount());//Adding should increase the count by one

	}
	/**
	 * Adds several elements at a position, and tests count. 
	 */
	@Test
	public void testAddAllIndexCollection() {
		iList.add("a");
		iList.add("b");
		iList.add("c");
		
		
		int count = iList.getAddCount();
		Collection<String> toAdd = new LinkedList<String>();
		toAdd.add("one");
		toAdd.add("two");
		toAdd.add("three");
		iList.addAll(2, toAdd);
		assertTrue(count+toAdd.size()==iList.getAddCount());
		
		
		
	}
	/**
	 * tests logical equlaity with several InstrumentedLIsts
	 */
	@Test
	public void testEquals(){
		LinkedList<String> first = new LinkedList<String>();
		LinkedList<String> second = new LinkedList<String>();
		LinkedList<String> third = new LinkedList<String>();
		InstrumentedList<String> firstList = new InstrumentedList<String>(first);
		InstrumentedList<String> secondList = new InstrumentedList<String>(second);	
		InstrumentedList<String> thirdList = new InstrumentedList<String>(third);
		
		firstList.add("one");
		firstList.add("two");
		firstList.add("three");
		secondList.add("one");
		secondList.add("two");
		assertFalse(firstList.equals(secondList));
		secondList.add("three");
		assertTrue(firstList.equals(secondList));//Symetry
		assertTrue(secondList.equals(firstList));
		thirdList.add("one");
		thirdList.add("two");
		thirdList.add("three");
		assertTrue(secondList.equals(thirdList));
		assertTrue(firstList.equals(thirdList));//Transitive
		
		secondList.remove("three");
		secondList.add("three");
		assertFalse(firstList.equals(secondList));//should nolonger be equal because of add count
		
		
	}
	/**
	 * tests hashcode with several InstrumentedLIsts
	 */
	@Test
	public void testHashCode(){
		LinkedList<String> first = new LinkedList<String>();
		LinkedList<String> second = new LinkedList<String>();
		InstrumentedList<String> firstList = new InstrumentedList<String>(first);
		InstrumentedList<String> secondList = new InstrumentedList<String>(second);	

		
		firstList.add("one");
		firstList.add("two");
		secondList.add("one");
		secondList.add("two");
		
		assertTrue(firstList.equals(secondList));//If equals is broken, can't test hashcode
		
		assertEquals(firstList.hashCode(),secondList.hashCode());
		
		
	}
	

}
