package study.loadertest;

import main.TestMain;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Object instance = MyLoader.getInstance("main.TestMain");
    	TestMain tm=(TestMain)instance;
    	System.out.println(tm.toString());
    	
    	ThreadLocal tl;
    }
}
