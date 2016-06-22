package cn.simple.src_study;

public class TestArray<E> {

	 //static E[] EMPTY_ARRAY={};
//	 final Class<? extends E>[] a={};
	transient Class<? extends E>[] elements;
	
	
	
	
	Class<? extends E> getElement(int index,Class<? extends E> obj)
	{
		return elements[index];
	}
}
