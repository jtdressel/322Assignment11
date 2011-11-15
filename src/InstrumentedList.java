//InstrumentedList.java
/**
 * @author James Dressel
 *
 */
import java.util.List;
import java.util.Collection;

public class InstrumentedList<E> extends ForwardingList<E> {
	private int addCount = 0;
	public InstrumentedList(List<E> l){
		super(l);
	}
	/**
	 * Appends the specified element to the end of this list.
	 * @param e element to add
	 */
	@Override public boolean add(E e){
		addCount++;
		return super.add(e);
	}
	/**
	 * Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator (optional operation).
	 * @param c collection to add. 
	 */
	@Override public boolean addAll(Collection <? extends E> c){
		addCount += c.size();
		return super.addAll(c); 
	}
	/**
	 * Inserts the specified element at the specified position in this list (optional operation).
	 * @param index Position to insert
	 * @param element element to insert
	 */
	@Override
	public void add(int index, E element) {
		addCount++;
		super.add(index, element);
	}
	/**
	 * Inserts all of the elements in the specified collection into this list at the specified position (optional operation).
	 * @param index position to add in.
	 * @param c collection to add
	 */
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(index, c);
	}
	/**
	 * 
	 * @return the number of elements that have been added. 
	 */
	public int getAddCount(){
		return addCount;
	}
	/**
	 * @param o Object to check equality. 
	 * @return true if objects are equal, false otherwise. 
	 */
	@Override
	public boolean equals(Object o){
		if(o instanceof InstrumentedList){
			if(super.equals(o)){
				@SuppressWarnings("rawtypes")
				InstrumentedList e = (InstrumentedList)o;
				if(this.addCount==e.addCount){
					return true;
				}
				
			} else {
				return false;
			}
		} else{
			return false;
		}
		return false;
		
		

	}
	/**
	 * @return a hash code value
	 */
	@Override
	public int hashCode(){
		int result = super.hashCode();
		result = result * 31 + addCount;
		return result;
	}
}
