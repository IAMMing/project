package com.simple.myloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
	private String name;
	private String path = "d:\\";
	private final String fileType = ".class";

	public MyClassLoader(String name) {
		super();
		this.name = name;
	}

	public MyClassLoader(ClassLoader parent, String name) {
		super(parent);
		this.name = name;
	}

	public String toString() {
		return this.name;
	}

	public void setPath(String path) {
		this.path = path;
	}

	protected Class<?> findClass(String name) {
		byte[] data = this.loadClassData(name);
		if (data != null)
			return this.defineClass(name, data, 0, data.length);
		return null;
	}

	private byte[] loadClassData(String name) {
		InputStream is = null;
		byte[] data = null;
		ByteArrayOutputStream classFileStream = null;
		this.name = this.name.replace('.', '\\');
		System.out.println(this.name);
		name = name.replace('.', '\\');
		try {
			File file = new File(path + name + fileType);
			if (file.exists()) {
				is = new FileInputStream(file);
				classFileStream = new ByteArrayOutputStream();
				int ch = 0;
				while (-1 != (ch = is.read())) {
					classFileStream.write(ch);
				}
				data = classFileStream.toByteArray();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (classFileStream != null) {
					classFileStream.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return data;
	}
}
