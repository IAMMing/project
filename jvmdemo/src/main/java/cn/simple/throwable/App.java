package cn.simple.throwable;

public class App {

	public static void main(String[] args) {

		App app = new App();
		app.first1();
	}

	public void first1() {
		System.out.println("this is first1");
		first2();
	}

	public void first2() {
		System.out.println("this is first2");
		first3();
	}

	public void first3() {
		System.out.println("this is first3");
		Throwable throwable = new Throwable();
		StackTraceElement[] stackTrace = throwable.getStackTrace();
		StringBuilder sb = new StringBuilder();
		for (StackTraceElement stackTraceElement : stackTrace) {
			sb.append("at\t");
			sb.append(stackTraceElement.getClassName());
			sb.append("-");
			sb.append(stackTraceElement.getMethodName());
			sb.append("(");
			sb.append(stackTraceElement.getLineNumber());
			sb.append(")");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
