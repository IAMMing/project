package com.simple.enumdemo;

public enum EnumType {

	TYPE_ONE(1, "测试");

	private Integer value;
	private String desc;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private EnumType(int val, String desc) {
		this.value = val;
		this.desc = desc;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getValue() + "=" + getDesc();
	}
}
