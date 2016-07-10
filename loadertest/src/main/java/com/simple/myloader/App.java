package com.simple.myloader;

public class App {
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {

		MyClassLoader loader1 = new MyClassLoader("loader1");
		// loader1.setPath("G:\\project\\study\\loadertest\\target\\classes\\");
		loader1.setPath("d:\\loader1\\");
		//Class loadClass = loader1.loadClass("com.simple.myloader.TestLoader");
		Class loadClass = loader1.loadClass("com.simple.myloader.TestLoader");
		loadClass.newInstance();
	}
}
