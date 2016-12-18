package ClassLoaderDemo.plugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {

		Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });
		addURL.setAccessible(true);

		String url = "F:\\plugin.jar";

		JarFile jarFile = new JarFile(url);
		Enumeration<JarEntry> entries = jarFile.entries();
		while (entries.hasMoreElements()) {
			JarEntry je = entries.nextElement();
			if (je.getName().endsWith(".class")) {
				System.out.println(je.getName());
			}
		}
//		return;
		// ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		//
		// URL classURL = new URL(url);
		// addURL.invoke(classLoader, new Object[] { classURL });
		//
		// String className = "com.simple.FirstHello";
		// Class c = Class.forName(className);
		//
		//		 Object o = c.newInstance();
		// Class[] parameterTypes = {};
		// Method m = c.getDeclaredMethod("first", parameterTypes);
		// Object obj = m.invoke(o, null);
		// System.out.println(obj);
		//
		// Class[] parameterTypes1 = { String.class };
		// Method hello = c.getDeclaredMethod("hello", parameterTypes1);
		// Object[] os = { "Mr.Li" };
		// hello.invoke(o, os);
	}
}
