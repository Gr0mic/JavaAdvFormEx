package be.mms.ex04;

public class ArrayStack implements Stack {

	private Object[] elements;
	private int top;
	
	public ArrayStack(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("Invalid argument, 'capacity' >= 0");
		
		elements = new Object[capacity];
		top = -1;
	}
	
	@Override
	public void push(Object o) {
		if ( isFull() )
			throw new FullStackException("Full stack");
		
		elements[++top] = o;
	}

	@Override
	public Object pop() {
		if ( isEmpty() )
			throw new EmptyStackException("Empty stack");
		Object element = elements[top];
		elements[top--] = null;
		return element;
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top + 1 == elements.length;
	}

	@Override
	public Iterator iterator() {
		return new ArrayStackIterator();
	}
	
	private class ArrayStackIterator implements Iterator {
		
		private int p;

		@Override
		public Object next() {
			if (! hasNext() ) throw new NoSuchElementException("No Such Element");
			return elements[p++];
		}

		@Override
		public boolean hasNext() {
			return p <= top;
		}
		
	}
	

}
