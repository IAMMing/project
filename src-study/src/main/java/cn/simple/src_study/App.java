package cn.simple.src_study;

import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {

		// Map<String, String> map=new HashMap<String, String>();
		// Set<String> set=new HashSet<String>();
		//
		// for (String string : set) {
		//
		// }
		//
		// List<String> lst;
		// Class.forName("");
		// Stack<String> s;
		
//		Stack<String> s = new Stack<String>();
//		Vector<String> s=new Vector<String>();
//		Class clazz = s.getClass();
//		Class superclass = clazz.getSuperclass();
//		System.out.println(superclass.getName());
//		
//		Class[] interfaces = clazz.getInterfaces();
//		for (Class class1 : interfaces) {
//			System.out.println(class1.getName());
//		}
		
//		String a=null;
		System.out.println((-10 & 0x7FFFFFFF));
		
HashMap<String, String> map;
Hashtable<String, String> table = new Hashtable<String, String>();
for (Entry<String, String> string : table.entrySet()) {
	
}
		table.put(null, "");
		
		Integer.highestOneBit(1);
		// Connection connection = DriverManager.getConnection("");
		// PreparedStatement stat = connection.prepareStatement("?");
		// stat.setString(0, "");
		//
		//
		//
		// System.out.println( "Hello World!" );

		// int i=5;
		// System.out.println(i++);
		// System.out.println(i);
		// System.out.println("====");
		// System.out.println(++i);
		// System.out.println(i);
		// System.out.println("====");
		// System.out.println(i--);
		// System.out.println(i);
		// System.out.println("====");
		// System.out.println(--i);
		// System.out.println(i);
		// System.out.println("====");

//		try {
//			two();
//		} catch (Exception e) {
//			System.out.println("main 函数中抛出的异常");
//			e.printStackTrace(System.out);
//		}

	}

	public static void one() throws Exception {

		System.out.println("one 方法执行");
		throw new Exception("one 方法抛出的异常");
	}

	public static void two() throws Exception {

		try {
			one();
		} catch (Exception e) {
			System.out.println("two 捕获异常重置后重新抛出");
			e.printStackTrace(System.out);
			throw (Exception) e.fillInStackTrace();
		}
	}
}
