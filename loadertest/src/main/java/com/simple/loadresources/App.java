package com.simple.loadresources;

import java.net.URL;
import java.util.List;

public class App {
	public static void main(String[] args) {
		// ClassLoaderLoad();
		// instanceLoad();
		// abslotalyload();

//		 poLoad();

	}

	private static void poLoad() {
		URL url = App.class.getResource("App.class");
		System.out.println(url);
		url = List.class.getResource("Map.class");
		System.out.println(url);
	}

	/**
	 * 绝对路径加载
	 */
	private static void abslotalyload() {
		URL url = ClassLoader.class.getResource("/java/lang/String.class");
		System.out.println(url);
		url = App.class.getResource("/App.class");
		System.out.println(url);
		url = List.class.getResource("/java/lang/String.class");
		System.out.println(url);
	}

	/**
	 * 对象加载
	 */
	private static void instanceLoad() {
		URL url = App.class.getResource("java/lang/String.class");
		System.out.println(url);
		url = App.class.getResource("App.class");
		System.out.println(url);

		url = ClassLoader.class.getClassLoader().getResource("App.class");
		System.out.println(url);

		url = ClassLoader.class.getClassLoader().getResource(
				"java/lang/String.class");
		System.out.println(url);
	}

	/**
	 * 使用ClassLoader类加载资源
	 */
	private static void ClassLoaderLoad() {
		URL url = null;
		url = ClassLoader.getSystemResource("java/lang/String.class");
		System.out.println(url);
		url = ClassLoader.getSystemResource("App.class");
		System.out.println(url);
	}
}
