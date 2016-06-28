package study.loadertest;

public class MyLoader<T> {
	public static <T> T getInstance(String name) {
		try {
			Class<?> c = Class.forName(name);
			return (T) c.newInstance();
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
		return null;
	}
}
