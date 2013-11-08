package be.mms.ex06;

public class EvenPredicate implements Predicate<Integer> {

	@Override
	public boolean match(Integer o) {
		return o % 2 == 0;
	}

}
