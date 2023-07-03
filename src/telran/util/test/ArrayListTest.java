package telran.util.test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayListTest {
	 private ArrayList<Integer> collection;

	 @BeforeEach
	    void setUp() {
	        collection = new ArrayList<Integer>();
	    }
	 @Test
	 void testSet() {
	        collection.addAll(Arrays.asList(1, 2, 3, 4, 5));

	        int index = 2;
	        int newValue = 10;

	        int oldValue = collection.set(index, newValue);

	        assertEquals(3, oldValue);
	        assertEquals(newValue, collection.get(index));
	        assertEquals(5, collection.size());
	    }
	 

	    @Test
	    void testAddAll() {
	    	 collection.addAll(Arrays.asList(1, 2, 3));
	         assertTrue(collection.addAll(Arrays.asList(4, 5, 6)));
	         assertTrue(collection.containsAll(Arrays.asList(1, 2, 3, 4, 5, 6)));
	     
	    }

	    @Test
	    void testRemoveAll() {
	        collection.addAll(Arrays.asList(1, 2, 3, 4));
	        Collection<Integer> elementsToRemove = Arrays.asList(2, 4);
	        assertTrue(collection.removeAll(elementsToRemove));
	        assertEquals(2, collection.size());
	        assertFalse(collection.containsAll(elementsToRemove));
	    }

	    @Test
	    void testIterator() {
	        collection.addAll(Arrays.asList(1, 2, 3, 4));
	        Iterator<Integer> iterator = collection.iterator();
	        assertTrue(iterator.hasNext());
	        assertEquals(1, iterator.next());
	        assertEquals(2, iterator.next());
	        assertEquals(3, iterator.next());
	        assertEquals(4, iterator.next());
	        assertFalse(iterator.hasNext());
	    }

	    @Test
	    void testAdd() {
	    	collection.add(1);
	        collection.add(2);
	        collection.add(3);
	        collection.add(4);

	        assertEquals(4, collection.size());
	        assertEquals(0, collection.indexOf(1));
	        assertEquals(1, collection.indexOf(2));
	        assertEquals(2, collection.indexOf(3));
	        assertEquals(3, collection.indexOf(4));
	    
	    }
@Test
	    void testRemove() {
	        collection.addAll(Arrays.asList(1, 2, 3, 4));
	        assertEquals(2, collection.remove(1));
	        assertEquals(3, collection.size());
	        assertFalse(collection.contains(2));
	    }

	    @Test
	    void testIndexOf() {
	        collection.addAll(Arrays.asList(1, 2, 3, 4));
	        assertEquals(1, collection.indexOf(2));
	        assertEquals(3, collection.indexOf(4));
	    }

	    @Test
	    void testLastIndexOf() {
	        collection.addAll(Arrays.asList(1, 2, 3, 2, 4));
	        assertEquals(3, collection.lastIndexOf(2));
	        assertEquals(2, collection.lastIndexOf(3));
	    }
	    @Test
	    void testRemoveIf() {
	        collection.addAll(Arrays.asList(1, 2, 3, 4, 5));

	        Predicate<Integer> condition = num -> num % 2 == 0; 
	        assertTrue(collection.removeIf(condition));

	        assertFalse(collection.contains(2));
	        assertFalse(collection.contains(4));
	        assertTrue(collection.contains(5)); 
	        assertEquals(3, collection.size());
	    }
	    @Test
	    void testToArray() {
	        collection.addAll(Arrays.asList(1, 2, 3, 4, 5));
	        Object[] arr = collection.toArray();

	        assertEquals(5, arr.length);
	        assertArrayEquals(new Object[]{1, 2, 3, 4, 5}, arr);
	    }

	    @Test
	    void testSize() {
	        assertEquals(0, collection.size());

	        collection.add(1);
	        assertEquals(1, collection.size());

	        collection.addAll(Arrays.asList(2, 3, 4, 5));
	        assertEquals(5, collection.size());

	        collection.remove(1);
	        assertEquals(4, collection.size());
	    }
	}


	    
