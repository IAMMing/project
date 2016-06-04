package cn.simple.domain;

public class MyTest {
	private int id;
	private String tName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	@Override
	public String toString() {
		return this.id+"="+this.tName;
	}
	
}
