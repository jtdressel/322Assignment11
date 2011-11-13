//ForwardingList.java
// James Dressel

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
/**
 * @author James Dressel
 *
 */
public class ForwardingList<E> implements List<E>{
	private final List<E> l;
	public ForwardingList(List<E> l) {this.l = l;}
	
	
	
//TODO Ask about override notation
	/**
	 * Appends the specified element to the end of this list (optional operation)
	 * @return false if operation is unsucessful
	 */
	@Override
	public boolean add(E e) {
		return l.add(e);
	}
	/**
	 * Inserts the specified element at the specified position in this list (optional operation).
	 * @param index Position to insert
	 * @param element element to insert
	 */
	@Override
	public void add(int index, E element) {
		l.add(index, element);	
	}

	/**
	 * Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator (optional operation).
	 * @param c collection to add. 
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		
		return l.addAll(c);
	}

	/**
	 * Inserts all of the elements in the specified collection into this list at the specified position (optional operation).
	 * @param index position to add in.
	 * @param c collection to add
	 */
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	/**
	 * Removes all of the elements from this list (optional operation).
	 */
	@Override
	public void clear() {
		l.clear();
	}

	/**
	 * Returns true if this list contains the specified element.
	 * @param o Object to check status of
	 */
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return l.contains(o);
	}
	/**
	 * Returns true if this list contains all of the elements of the specified collection.
	 * @param c Collection to check elements of   
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		
		return l.containsAll(c);
	}

	/**
	 * Compares the specified object with this list for equality.
	 * @param index of the list to return
	 */
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return l.get(index);
	}

	/**
	 * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
	 * @param o Object to return the index of. 
	 */
	@Override
	public int indexOf(Object o) {
		return l.indexOf(o);
	}

	/**
	 * Returns true if this list contains no elements.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return l.isEmpty();
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 */
	@Override
	public Iterator<E> iterator() {
		return l.iterator();
	}

	/**
	 * Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
	 * @param o Object to return the last index of. 
	 */
	@Override
	public int lastIndexOf(Object o) {
		
		return l.lastIndexOf(o);
	}
	/**
	 * Returns a list iterator over the elements in this list (in proper sequence).
	 */
	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns a list iterator of the elements in this list (in proper sequence), starting at the specified position in this list.
	 * @param index to start iterator at 
	 */
	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Removes the first occurrence of the specified element from this list, if it is present (optional operation).
	 * @param o Object to remove
	 */
	@Override
	public boolean remove(Object o) {
		return l.remove(o);
		
	}

	/**
	 * Removes the element at the specified position in this list (optional operation).
	 * @param index of element to remove
	 */
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return l.remove(index);
	}

	/**
	 * Removes from this list all of its elements that are contained in the specified collection (optional operation).
	 * @param c Collection to remove
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return l.removeAll(c);
	}

	/**
	 * Retains only the elements in this list that are contained in the specified collection (optional operation).
	 * @param c Collection to retain
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
	
		return l.retainAll(c);
	}

	/**
	 * Replaces the element at the specified position in this list with the specified element (optional operation)
	 * @param index to replace at
	 * @param element to replace with
	 */
	@Override
	public E set(int index, E element) {
		
		return l.set(index, element);
	}
	/**
	 * Returns the number of elements in this list.
	 */
	@Override
	public int size() {
		return l.size();
	}
	/**
	 * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
	 * @param fromIndex the index to start with
	 * @param toIndex the index to end with
	 */
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return l.subList(fromIndex, toIndex);
	}
	/**
	 * Returns an array containing all of the elements in this list in proper sequence (from first to last element).
	 */
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Returns an array containing all of the elements in this list in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array.
	 *  
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		
		return l.toArray(a);
	}

}
