package com.simple.myloader;

public class App2 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	
		// TODO Auto-generated method stub
		MyClassLoader loader1 = new MyClassLoader("loader1");
		loader1.setPath("d:\\loader1\\");
		MyClassLoader loader2 = new MyClassLoader(loader1,"loader2");
		loader2.setPath("d:\\loader2\\");
		Class<?> loadClass = loader2.loadClass("LoaderTest");
		Object ob = loadClass.newInstance();

	}
}
