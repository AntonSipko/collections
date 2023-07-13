package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Collection;
import telran.util.Set;

public abstract class SetTest extends CollectionTest {

	@Override
	@Test
	void addTest() {
		assertFalse(collection.add(10));
		runArrayTest(numbers, collection.toArray(new Integer[0]));
		
	}
	
	@Test
	void getPatternTest() {
		assertEquals(numbers[1],((Set<Integer>)collection).get(numbers[1]));
	}
}
