package com.simple;

public class ClassLoaderDemo {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
		System.out.println(classLoader);
		System.out.println(classLoader.getSystemClassLoader());
		System.out.println("=========================================");
		ClassLoader parent = classLoader.getParent();
		ClassLoader classLoader2 = classLoader.getClass().getClassLoader();
		System.out.println(parent);
		System.out.println(classLoader2);
		System.out.println(parent.getSystemClassLoader());
		System.out.println("=========================================");

		ClassLoader classLoader3 = sun.misc.Launcher.getLauncher().getClassLoader();
		System.out.println("launcher:" + classLoader3);
		System.out.println("launcher:" + classLoader3.getParent());
		System.out.println("launcher:" + classLoader3.getParent().getParent());
		

	}

}
