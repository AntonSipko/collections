package telran.util.test;
import telran.util.HashSet;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;

import telran.util.Collection;

public class HashSetTest<T> extends SetTest {
	@Override
	@BeforeEach
	void setUp() {
		collection=new HashSet<Integer>(3);
		super.setUp();
	}

	@Override
	protected Collection<Integer> getCollection(Integer[] ar1) {
		HashSet<Integer> res=new HashSet<>();
		for(Integer num:ar1) {
			res.add(num);
		}
		return res;
	}

	@Override
	protected void runArrayTest(Integer[] expected, Integer[] actual) {
		Integer[] expectedSorted=Arrays.copyOf(expected, expected.length);
		Integer[] actualSorted=Arrays.copyOf(actual, actual.length);
		Arrays.sort(expectedSorted);
		Arrays.sort(actualSorted);
		assertArrayEquals(expectedSorted,actualSorted);

	}

}
