package be.mms.ex06;

public class GreatherThanPredicate implements Predicate<Integer> {
	private int value;
	
	
	
	public GreatherThanPredicate(int value) {
		this.value = value;
	}



	@Override
	public boolean match(Integer o) {
		return o > value;
	}

}
