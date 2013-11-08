package be.mms.ex06;

import java.util.LinkedList;
import java.util.List;

public class Lists {
	
	public static <T> List<T> select(List<T> items, Predicate<T> predicate) {
		List<T> rItems = new LinkedList<T>();
		for (T i : items) {
			if ( predicate.match(i) ) rItems.add(i);
		}
		return rItems;
	}
	
}
