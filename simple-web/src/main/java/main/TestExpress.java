package main;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TestExpress {

	public static void main(String[] args) throws ScriptException {
		String str = "43*(2 + 1.4)+2*32/(3-2.1)";
		test2(str);
		str="1-2";
		test2(str);
	}
	public static void test2(String str) throws ScriptException {  
//		String str = "43*(2 + 1.4)+2*32/(3-2.1)";  
		ScriptEngineManager manager = new ScriptEngineManager();  
		ScriptEngine engine = manager.getEngineByName("js");  
		Object result = engine.eval(str);  
		System.out.println("结果类型:" + result.getClass().getName() + ",计算结果:" + result);  
	}  
}
