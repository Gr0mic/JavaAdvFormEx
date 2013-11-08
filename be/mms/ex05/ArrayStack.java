package be.mms.ex05;

public class ArrayStack<O> implements Stack<O> {

	private O[] elements;
	private int top;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("Invalid argument, 'capacity' >= 0");
		
		elements = (O[]) new Object[capacity];
		top = -1;
	}
	
	@Override
	public void push(O o) {
		if ( isFull() )
			throw new FullStackException("Full stack");
		
		elements[++top] = o;
	}

	@Override
	public O pop() {
		if ( isEmpty() )
			throw new EmptyStackException("Empty stack");
		O element = elements[top];
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
	public Iterator<O> iterator() {
		return new ArrayStackIterator();
	}
	
	private class ArrayStackIterator implements Iterator<O> {
		
		private int p;

		@Override
		public O next() {
			if (! hasNext() ) throw new NoSuchElementException("No Such Element");
			return elements[p++];
		}

		@Override
		public boolean hasNext() {
			return p <= top;
		}
		
	}
	

}
