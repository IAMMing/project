package com.simple.myloader;

public class App2 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	
		// TODO Auto-generated method stub
		MyClassLoader loader1 = new MyClassLoader("loader1");
		loader1.setPath("d:\\loader1\\");
		MyClassLoader loader2 = new MyClassLoader(loader1,"loader2");
		loader2.setPath("d:\\loader2\\");
		
		MyClassLoader loader3 = new MyClassLoader(loader2,"loader3");
		loader3.setPath("d:\\loader3\\");
		
		Class<?> loadClass = loader3.loadClass("LoaderTest");
		Object ob = loadClass.newInstance();

	}
}
