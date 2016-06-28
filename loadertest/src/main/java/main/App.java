package main;


public class App {
	public static void main(String[] args) {
		
		System.out.println("测试ClassLoader.getSystemClassLoader()");
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		try {
			Class<?> loadClass = systemClassLoader.loadClass("main.TestMain");
			ClassLoader cl = loadClass.getClassLoader();
			System.out.println("sys:" + cl);
			System.out.println("sysparent:" + cl.getParent());
			TestMain tm = (TestMain) loadClass.newInstance();
			System.out.println(tm.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("测试classforname");
		try {
			Class<?> forName = Class.forName("main.TestMain");
			ClassLoader classLoader = forName.getClassLoader();
			System.out.println("forname:"+classLoader);
			System.out.println("fornameParent:"+classLoader.getParent());
			TestMain tm=(TestMain)forName.newInstance();
			System.out.println(tm.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
