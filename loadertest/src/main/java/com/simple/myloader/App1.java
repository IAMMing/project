package com.simple.myloader;

public class App1 {
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		MyClassLoader2 loader1 = new MyClassLoader2("loader1");
		loader1.setPath("d:\\loader1\\");
		Class<?> loadClass = loader1.loadClass("LoaderTest");
		Object ob = loadClass.newInstance();
	}
}
