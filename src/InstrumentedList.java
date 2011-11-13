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
		//TODO
		return false;
	}
	
	public int getAddCount(){
		return addCount;
	}
}
