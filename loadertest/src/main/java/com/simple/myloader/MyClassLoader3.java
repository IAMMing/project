package com.simple.myloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MyClassLoader3 extends ClassLoader {
	private String name;
	private String path = "d:\\";
	private final String fileType = ".class";

	public MyClassLoader3(String name) {
		super();
		this.name = name;
	}

	public MyClassLoader3(ClassLoader parent, String name) {
		super(parent);
		this.name = name;
		/**
		 * 设置线程上线文加载器
		 */
		System.out.println("设置了线程上下文类:"+this.name);
		Thread.currentThread().setContextClassLoader(this);
	}

	public String toString() {
		return this.name;
	}

	public void setPath(String path) {
		this.path = path;
	}

	protected Class<?> findClass(String name) {
		byte[] data = this.loadClassData(name);
		return this.defineClass(name, data, 0, data.length);
	}

	private byte[] loadClassData(String name) {
		InputStream is = null;
		byte[] data = null;
		ByteArrayOutputStream classFileStream = null;
		this.name = this.name.replace('.', '\\');
		System.out.println("受托加载对象为："+this.name);
		name = name.replace('.', '\\');
		try {
			File file = new File(path + name + fileType);
			is = new FileInputStream(file);
			classFileStream = new ByteArrayOutputStream();
			int ch = 0;
			while (-1 != (ch = is.read())) {
				classFileStream.write(ch);
			}
			data = classFileStream.toByteArray();

		} catch (Exception e) {
			// e.printStackTrace();

			System.out.println(e.getMessage());

			try {
				MyClassLoader3 loader3 = (MyClassLoader3) Thread
						.currentThread().getContextClassLoader();
				this.name = loader3.name.replace('.', '\\');
				System.out.println("异常后取出来的上下文类加载器:" + loader3.name+":"+loader3.getPath());
				is = new FileInputStream(new File(loader3.getPath() + name
						+ fileType));
				
				classFileStream=new ByteArrayOutputStream();
				int ch = 0;
				while (-1 != (ch = is.read())) {
					classFileStream.write(ch);
				}
				data = classFileStream.toByteArray();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} finally {
			try {
				is.close();
				classFileStream.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return data;
	}

	private String getPath() {
		// TODO Auto-generated method stub
		return this.path;
	}
}
