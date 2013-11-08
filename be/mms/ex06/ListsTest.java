package be.mms.ex06;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class ListsTest {

	public static void main(String[] args) throws ParseException {
		List<Integer> start = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

		System.out.println(start);
		System.out.println( 
				Lists.select( start, new EvenPredicate() ) );
		System.out.println(
				Lists.select( start, new GreatherThanPredicate(3) ) );

	}

}
