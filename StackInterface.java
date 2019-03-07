
public interface StackInterface<T> {

	public void push(T item) throws StackFullException;
	
	public void pop() throws StackEmptyException;
	
	public T top() throws StackEmptyException;
	
	public int size();
	

}
