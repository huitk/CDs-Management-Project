
public class ArrayBasedStack<T> implements StackInterface<T> {
	
	private int top;
	private T [] stack;
	private int size;
	
	public ArrayBasedStack() {
		top = -1;
		size = 0;
		stack = (T[]) new Object[100];
	}
	
	public ArrayBasedStack(int sizeOfStack) {
		top = -1;
		size = 0;
		stack = (T[])new Object[sizeOfStack];
	}

	@Override
	public void push(T item) throws StackFullException {
		// TODO Auto-generated method stub
		if(top < stack.length-1) {
			top++;
			size++;
			stack[top] = item;
		}
		else
			throw new StackFullException("Push attempted on a full stack! No more can be added");
	}

	@Override
	public void pop() throws StackEmptyException {
		// TODO Auto-generated method stub
		if(top > -1) {
			stack[top] = null;
			top--;
			size--;
		}
		else throw new StackEmptyException("Pop attempted on a empty stack!");
			
	}

	@Override
	public T top() throws StackEmptyException {
		// TODO Auto-generated method stub
		if(top > -1)
			return stack[top];
		else
			throw new StackEmptyException("Top attempted on an empty stack");
	}

	
	
	public String toString() {
		String allItems = "";
		for(int i = top; i > -1; i--) {
			allItems = allItems + " \n" + stack[i].toString();
			
		}
		return allItems;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	
	

}
