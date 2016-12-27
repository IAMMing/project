package com.zero.traversal.bean;

import java.util.ArrayList;
import java.util.List;

public class ParentBean {
	private String parent;
	private List<ChildBean> list = new ArrayList();

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public List<ChildBean> getList() {
		return list;
	}

	public void setList(List<ChildBean> list) {
		this.list = list;
	}

}
