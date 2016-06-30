package main;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class App {
	public static void main(String[] args) {
		// String mw = "111";
		// String encodeBase64 = Base64.encodeBase64String(mw.getBytes());
		// System.out.println(encodeBase64);
		// String decode =new String(Base64.decodeBase64(encodeBase64));
		// System.out.println(decode);
		// System.out.println();
		// String md5Hex = DigestUtils.md5Hex(mw);
		// System.out.println(md5Hex);
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
