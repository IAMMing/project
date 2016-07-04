package com.simple.first;

import java.net.URL;

public class App {
	public static void main(String[] args) {

		URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		System.out.println("根加载器加载的jar");
		for (URL url : urLs) {
			System.out.println(url.toExternalForm());
		}
		System.out.println("扩展加载器加载的jar");
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println("系统加载器加载的jar");
		String[] paths = System.getProperty("java.class.path").split(";");
		for (String path : paths) {
			System.out.println(path);
		}
	}
}
