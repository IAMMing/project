package cn.simple.datasource;

public class DataSourceHolder {
	private static final ThreadLocal<String> targetDataSource = new ThreadLocal<String>();

	public static String getTargetDatasource() {
		return targetDataSource.get();
	}

	public static void setTargetDataSource(String dataSourceName) {
		targetDataSource.set(dataSourceName);
	}

	public static void clearTargetDataSource() {
		targetDataSource.remove();
	}
}
