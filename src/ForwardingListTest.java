import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.List;
import java.util.LinkedList;
import java.util.HashSet;

//TODO: Consider how to test iterators
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
		assertTrue(stringList.isEmpty());//Nothing in list to begin with
		stringList.add("one");
		assertFalse(stringList.isEmpty());//Now there is one element, not empty
		stringList.remove("one");
		assertTrue(stringList.isEmpty());
	}

	@Test
	public void testLastIndexOf() {
		stringList.add("one");
		stringList.add("two");
		stringList.add("one");
		assertEquals(2, stringList.lastIndexOf("one"));
	}


	@Test
	public void testRemoveObject() {
		assertTrue(stringList.isEmpty());
		assertFalse(stringList.contains("one"));
		stringList.add("one");
		stringList.add("two");
		stringList.add("one");//"one" is in index 0 and 2
		assertTrue(stringList.contains("one"));
		stringList.remove("one");//should remove "one" from index 0, making two be in 0, and one in 1
		assertEquals(1,stringList.indexOf("one"));//if false then it removed the last object instead of the first
		stringList.remove("one");//no more "one"
		assertFalse(stringList.contains("one"));
		
	}

	@Test
	public void testRemoveInt() {
		assertTrue(stringList.isEmpty());
		stringList.add("one");
		stringList.add("two");
		stringList.add("three");
		//one, two three
		stringList.remove(1);//test remove in middle
		//one, three
		assertFalse(stringList.contains("two"));
		stringList.remove(1);//test remove at end
		assertFalse(stringList.contains("three"));
		stringList.remove(0);//test remove at beginning
		assertFalse(stringList.contains("one"));
		
	}

	@Test
	public void testRemoveAll() {
		HashSet<String> set = new HashSet<String>();
		set.add("one");
		set.add("two");
		stringList.add("one");
		stringList.add("two");
		assertFalse(stringList.isEmpty());
		stringList.removeAll(set);
		assertTrue(stringList.isEmpty());
	
	}

	@Test
	public void testRetainAll() {
		HashSet<String> set = new HashSet<String>();
		set.add("one");
		set.add("two");
		stringList.add("one");
		stringList.add("two");
		stringList.add("other");
		stringList.add("blah");

		assertTrue(stringList.contains("one"));
		assertTrue(stringList.contains("two"));
		assertTrue(stringList.contains("other"));
		assertTrue(stringList.contains("blah"));
		
		stringList.retainAll(set);//keep one and two, remove others
		
		assertTrue(stringList.contains("one"));
		assertTrue(stringList.contains("two"));
		assertFalse(stringList.contains("other"));
		assertFalse(stringList.contains("blah"));
		
		
	}

	@Test
	public void testSet() {
		stringList.add("one");
		stringList.add("one");
		stringList.add("three");
		stringList.add("four");
		assertEquals("one",stringList.get(1));//currently "one"
		stringList.set(1, "two");
		assertEquals("two",stringList.get(1));//Should have been changed to "two"
		
		
		
	}

	@Test
	public void testSize() {
		assertEquals(0, stringList.size());//Start out empty
		stringList.add("one");
		assertEquals(1, stringList.size());
		stringList.add("two");
		assertEquals(2, stringList.size());
		stringList.remove("two");
		assertEquals(1, stringList.size());
		
	}

	@Test
	public void testSubList() {
		stringList.add("zero");
		stringList.add("one");
		stringList.add("two");
		stringList.add("three");
		stringList.add("four");
		stringList.add("five");
		
		LinkedList<String> testList = new LinkedList<String>();
		
		testList.add("two");
		testList.add("three");
		testList.add("four");
		
		assertEquals(testList, stringList.subList(2, 5));
		
	}

	@Test
	public void testToArray() {
		stringList.add("zero");
		stringList.add("one");
		stringList.add("two");
		
		Object[] testArray = new Object[3]; 
		testArray[0]= "zero";
		testArray[1]= "one";
		testArray[2]= "two";
		
		assertEquals(testArray,stringList.toArray());
		
	}

	@Test
	public void testToArrayTArray() {
		String[] testArray = new String[3];
		testArray[0]= "zero";
		testArray[1]= "one";
		testArray[2]= "two";
		String[] stringArray = new String[2];
		stringList.add("zero");
		stringList.add("one");
		stringList.add("two");
		assertEquals(testArray,stringList.toArray(stringArray));
		
	}

	@Test
	public void testHashCode() {
		stringList.add("one");
		
		LinkedList<String> testLink = new LinkedList<String>();
		ForwardingList<String> list = new ForwardingList<String>(testLink);
		
		list.add("one");//both stringList and list contain only one
		
		assertTrue(list.equals(stringList));
		assertEquals(list.hashCode(),stringList.hashCode());//If equal hashcode should be equal
	}

	@Test
	public void testEquals() {
		
		LinkedList<String> testLink = new LinkedList<String>();
		ForwardingList<String> list = new ForwardingList<String>(testLink);

		LinkedList<String> testTwoLink = new LinkedList<String>();
		ForwardingList<String> listTwo = new ForwardingList<String>(testTwoLink);
		
		stringList.add("one");
		listTwo.add("one");
		list.add("one");
		assertTrue(stringList.equals(list));
		assertTrue(list.equals(stringList));//Symmetric
		assertTrue(list.equals(listTwo));
		assertTrue(stringList.equals(listTwo));//transitive
		
		
		
		assertTrue(list.equals(stringList));
	}

	@Test
	public void testToString() {
		stringList.add("one");
		stringList.add("two");
		stringList.add("three");
		assertEquals("[one, two, three]", stringList.toString());
		
	}

}
