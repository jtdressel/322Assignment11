import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.List;
import java.util.LinkedList;

public class ForwardingListTest {
	private List<String> stringLinkedList;
	private ForwardingList<String> stringList;
	
	@Before public void setUp(){
		stringLinkedList = new LinkedList<String>();
		stringList = new ForwardingList<String>(stringLinkedList);
	}
	
	
	@Test
	public void testAddIntE() {
		stringList.add("one");
		stringList.add("two");
		stringList.add("three");
		stringList.add(2, "test");
		assertEquals("test",stringList.get(2));
	}

	@Test
	public void testAddAllCollectionOfQextendsE() {
		LinkedList<String> newList = new LinkedList<String>();
		newList.add("one");
		newList.add("two");
		newList.add("three");
		newList.add("four");
		assertFalse(stringList.containsAll(newList));
		
		stringList.addAll(newList);
		assertTrue(stringList.containsAll(newList));
		
	}

	@Test
	public void testAddAllIntCollectionOfQextendsE() {
		LinkedList<String> newList = new LinkedList<String>();
		newList.add("one");
		newList.add("two");
		newList.add("three");
		newList.add("four");
		assertFalse(stringList.containsAll(newList));
		
		stringList.add("a");
		stringList.addAll(0,newList);
		assertEquals(stringList.get(4), "a");//the first element is moved to the end
		
		assertTrue(stringList.containsAll(newList));//make sure all are added
		
		
		
		
	}

	@Test
	public void testClear() {
		//TODO Add more elements
		stringList.add("test");
		assertFalse(stringList.isEmpty());//Make sure there are elements
		stringList.clear();
		
		assertTrue(stringList.isEmpty());//Make sure there are no more elemnts
		
	}

	@Test
	public void testContains() {
		//TODO : Ensure empty start
		assertTrue(stringList.isEmpty());
		stringList.add("one");//one
		stringList.add("two");//one, two
		stringList.add("three");//one,two,three
		assertTrue(stringList.contains("one"));
		assertTrue(stringList.contains("two"));
		assertTrue(stringList.contains("three"));
		stringList.remove(1);//one, three
		
		assertFalse(stringList.contains("two"));


	}

	@Test
	public void testContainsAll() {
		
		LinkedList<String> newList = new LinkedList<String>();
		newList.add("one");
		newList.add("two");
		newList.add("three");
		newList.add("four");
		assertFalse(stringList.containsAll(newList));
		
		stringList.addAll(newList);
		
		assertTrue(stringList.containsAll(newList));//make sure all are added
		
		
		
	}

	@Test
	public void testGet() {
		stringList.add("zero");
		stringList.add("one");
		stringList.add("two");
		assertEquals("zero",stringList.get(0));
		assertEquals("one",stringList.get(1));
		assertEquals("two",stringList.get(2));
	}

	@Test
	public void testIndexOf() {
		assertEquals(-1,stringList.indexOf("one"));//"one" is not in stringList
		stringList.add("one");
		assertEquals(0, stringList.indexOf("one"));//one is in index 0
		stringList.add("two");
		stringList.add("three");
		assertEquals(1, stringList.indexOf("two"));
		
		
		
	}

	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testIterator() {
		fail("Not yet implemented");
	}

	@Test
	public void testLastIndexOf() {
		fail("Not yet implemented");
	}

	@Test
	public void testListIterator() {
		fail("Not yet implemented");
	}

	@Test
	public void testListIteratorInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetainAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testSet() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testSubList() {
		fail("Not yet implemented");
	}

	@Test
	public void testToArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testToArrayTArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
