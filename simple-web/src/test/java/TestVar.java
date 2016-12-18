import java.io.IOException;

import org.jsoup.Jsoup;
import org.junit.Test;

public class TestVar {

	@Test
	public void testJstl() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			try {
				String document = Jsoup.connect("http://localhost:8080/news/test/jstl").get().body().text();
				System.out.println(document);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end + "-" + start + "=" + (end - start));
	}

	@Test
	public void testVar() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			try {
				String document = Jsoup.connect("http://localhost:8080/news/test/var").get().body().text();
				System.out.println(document);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end + "-" + start + "=" + (end - start));
	}
}
