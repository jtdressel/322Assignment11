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
		return false;//TODO 
	}
	
	@Override public boolean addAll(Collection <? extends E> c){
		return false; //TODO
	}
	@Override
	public void add(int index, E element) {
		//TODO
	}
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		//TODO
		return false;
	}
	
	public int getAddCount(){
		return 0;//TODO
	}
}
