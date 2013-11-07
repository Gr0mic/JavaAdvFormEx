package be.mms.ex04;

public class ArrayStackTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack stack = new ArrayStack(4);
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println("pop():"+stack.pop());
		//System.out.println(stack.pop());
		//System.out.println(stack.pop());
				
		for (Iterator it = stack.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
		
		System.out.println("Push 5");
		stack.push(5);
		
		for (Iterator it = stack.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
		
	}

}
