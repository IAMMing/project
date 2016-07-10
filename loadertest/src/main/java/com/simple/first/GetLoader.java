package com.simple.first;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class GetLoader {
	public static void main(String[] args) {
		ClassLoader c1 = String.class.getClassLoader();
		System.out.println("String:" + c1);

		ClassLoader cInt = Integer.class.getClassLoader();
		System.out.println("Integer:" + cInt);

		ClassLoader cMap = HashMap.class.getClassLoader();
		System.out.println("Map:" + cMap);

		int i = 5;
		if (i == 4) {
			System.out.println(i);
		}

		ClassLoader cList = List.class.getClassLoader();
		System.out.println("List:" + cList);

		ClassLoader cCollection = Collection.class.getClassLoader();
		System.out.println("Collection:" + cCollection);

		ClassLoader cArrayList = ArrayList.class.getClassLoader();
		System.out.println("ArrayList:" + cArrayList);

		ClassLoader cObject = Object.class.getClassLoader();
		System.out.println("Object:" + cObject);

		ClassLoader c2 = GetLoader.class.getClassLoader();
		System.out.println(c2);
	}
}
