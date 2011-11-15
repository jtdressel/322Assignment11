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
	
	@Override public boolean addAll(Collection <? extends E> c){
		addCount += c.size();
		return super.addAll(c); 
	}
	@Override
	public void add(int index, E element) {
		addCount++;
		super.add(index, element);
	}
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(index, c);
	}
	
	public int getAddCount(){
		return addCount;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof InstrumentedList){
			if(super.equals(o)){
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
	
	@Override
	public int hashCode(){
		int result = super.hashCode();
		result = result * 31 + addCount;
		return result;
	}
}
