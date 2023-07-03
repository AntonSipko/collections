package telran.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ArrayList<T> implements List<T> {
	private static final int DEFAULT_CAPACITY = 16;
	private T[] array;
	private int size;
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		array=(T[]) new Object[capacity];
	}
	public ArrayList() {
		this(DEFAULT_CAPACITY);
		
	}

	@Override
	public boolean add(T obj) {
		if(size==array.length) {
			reallocate();
		}
		array[size++]=obj;
		return true;
	}

	private void reallocate() {
		array=Arrays.copyOf(array, array.length*2);
		
	}
	@Override
	public boolean remove(Object pattern) {
		boolean res=false;
		for(int i=0;i<size;i++) {
			if(array[i]==pattern) {
				System.arraycopy(array, 0, array, 0, i);
				System.arraycopy(array, i+1, array, i, size-i);
				size--;
				res=true;
			}
		}
		return res;
	}

	@Override
	public T[] toArray(T[] ar) {
		T[] res=ar.length<size?Arrays.copyOf(ar, size):ar;
		int index=0;
		for(T obj:this) {
			res[index++]=obj;
		}
		if(res.length>size) {
			res[size]=null;
		}
		return res;
	}

	@Override
	public boolean removeIf(Predicate<T> predicate) {
		boolean res=false;
    	Iterator<T>it=iterator();
    	 while (it.hasNext()) {
    	        T obj = it.next();
    	        if (predicate.test(obj)) {
    	            it.remove();
    	            res = true;
    	        }
    	    }
    	    
    	    return res;
		
	}

	@Override
	public int size() {
		int index=0;
		while(index<array.length&&array[index]!=null) {
			index++;
		}
		
		return index>Integer.MAX_VALUE?Integer.MAX_VALUE:index;
	}

	@Override
	public boolean addAll(Collection<T> collection) {
		int newSize=size+collection.size();
		array=Arrays.copyOf(array, newSize);
		if(newSize>=array.length) {
			reallocate();
		}
		int i=size;
		for(T element:collection) {
			array[i++]=element;
			
		}
		size=newSize;
		return true;
	}

	@Override
	public boolean removeAll(Collection<T> collection) {
		size=0;
		array=Arrays.copyOf(array, size);
		return true;
		
	}
		

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int currentIndex=0;
			boolean flNext=false;

			@Override
			public boolean hasNext() {
				return currentIndex<size;
				
			}

			@Override
			public T next() {
				if(!hasNext()) {
					throw new NoSuchElementException();
				}
				flNext = true;
				return array[currentIndex++];
			}
			
		};
	}
	@Override
	public void add(int index, T obj) {
		isIndexValid(index, true);
		if(size==array.length) {
			reallocate();
		}
		System.arraycopy(array, index, array, index+1, size-index);
		array[index]=obj;
		size++;
		
	}

	@Override
	public T get(int index) {
		isIndexValid(index, false);
		
		return array[index];
	}

	@Override
	public T set(int index, T obj) {
		isIndexValid(index, true);
		T oldObj=array[index];
		array[index]=obj;
	
		return oldObj;
	}

	@Override
	public T remove(int index) {
		T res=array[index];
		isIndexValid(index,false);
		size--;
		System.arraycopy(array, 0, array, 0, index);
		System.arraycopy(array, index+1, array, index, size-index);
		array[size]=null;
		return res;
	}

	private void isIndexValid(int index, boolean sizeInclusive) {
		int bounder=sizeInclusive?size+1:size;
		if(index<0||index>bounder) {
			throw new IndexOutOfBoundsException(index);
		}
		
	}
	@Override
	public int indexOf(T pattern) {
		int res=-1;
		for(int i=0;i<size;i++) {
			if(pattern.equals(array[i])) {
				res=i;
			}
		}
	return res;
	}

	@Override
	public int lastIndexOf(T pattern) {
		int res=-1;
		for(int i=size-1;i>=0;i++) {
			if(pattern.equals(array[i])) {
				res=i;
			}
		}
		return res;
	}

	@Override
	public int indexOf(Predicate<T> predicate) {
		int res=-1;
		for(int i=0;i<size;i++) {
			if(predicate.test(array[i])) {
				res=i;
			}
			
		}
		return res;
	}

	@Override
	public int lastIndexOf(Predicate<T> predicate) {
		int res=-1;
		for(int i=size-1;i>=0;i++) {
			if(predicate.test(array[i])) {
				res=i;
			}
		}
		return res;
	}

}