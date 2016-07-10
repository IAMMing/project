
public class LoaderTest {
	public int v1 = 1;

	public LoaderTest() {
		System.out.println("load... by :" + this.getClass().getClassLoader());
	}
}
