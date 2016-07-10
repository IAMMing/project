package com.simple.myloader;

public class App3 {
	public static void main(String[] args)  throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		MyClassLoader loader3 = new MyClassLoader(null, "loader3");
		
		loader3.setPath("d:\\loader1\\");
		Class<?> loadClass = loader3.loadClass("LoaderTest");
		Object ob = loadClass.newInstance();
	}
}
