package telran.util.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;

import telran.util.Collection;
import telran.util.LinkedList;

public class LinkedListTest extends ListTest {
	@Override
	@BeforeEach
	void setUp() {
		collection = new LinkedList<Integer>();
		super.setUp();
	}
	@Override
	protected Collection<Integer> getCollection(Integer[] ar) {
		LinkedList<Integer> res = new LinkedList<>();
		for(Integer num: ar) {
			res.add(num);
		}
		return res;
	}
	@Override
	protected void runArrayTest(Integer[] expected,Integer[] actual) {
		assertArrayEquals(expected, actual);
		
	}

}