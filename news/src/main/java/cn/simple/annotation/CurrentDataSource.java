package cn.simple.annotation;

public @interface CurrentDataSource {
	String name() default "testDataSource";
}
