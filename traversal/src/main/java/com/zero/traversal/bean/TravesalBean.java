package com.zero.traversal.bean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONValue;

public class TravesalBean {

	public <T> void searchField(List<T> srcList, List<T> destList, Class tClass) throws Exception {
		for (T src : srcList) {
			Field[] declaredFields = src.getClass().getDeclaredFields();
			T dest = (T) tClass.newInstance();
			for (Field field : declaredFields) {
				System.out.println(field.getName());
				String getterMethod = getterMethod(field.getName());
				Method getMethod = src.getClass().getDeclaredMethod(getterMethod);
				Object srcValue = getMethod.invoke(src);
				if (field.getType().isAssignableFrom(List.class)) {
					Object tempList = srcValue.getClass().newInstance();
					searchField((List) srcValue, (List) tempList, getGenericType(field));
					String setterMethod = setterMethod(field.getName());
					Method method = dest.getClass().getDeclaredMethod(setterMethod);
					method.invoke(dest, tempList);
				} else {
					String setterMethod = setterMethod(field.getName());
					Method method = dest.getClass().getDeclaredMethod(setterMethod, field.getType());
					method.invoke(dest, srcValue);
				}
			}
			destList.add(dest);
		}
	}

	private Class getGenericType(Field field) {
		ParameterizedType pt = (ParameterizedType) field.getGenericType();
		return pt.getActualTypeArguments()[0].getClass();
	}

	private String setterMethod(String fieldName) {
		char[] charArray = fieldName.toCharArray();
		charArray[0] -= 32;
		return "set" + String.valueOf(charArray);
	}

	private String getterMethod(String fieldName) {
		char[] charArray = fieldName.toCharArray();
		charArray[0] -= 32;
		return "get" + String.valueOf(charArray);
	}

	public static void main(String[] args) {
		List<ParentBean> listSrc = new ArrayList<>();
		ParentBean parentBean = new ParentBean();
		parentBean.setParent("p1");
		ChildBean childBean = new ChildBean();
		childBean.setChild("c1");
		parentBean.getList().add(childBean);
		childBean = new ChildBean();
		childBean.setChild("c2");
		parentBean.getList().add(childBean);
		childBean = new ChildBean();
		childBean.setChild("c3");
		parentBean.getList().add(childBean);

		listSrc.add(parentBean);
		List<ParentBean> listDest = new ArrayList<>();
		TravesalBean travesalBean = new TravesalBean();
		try {
			travesalBean.searchField(listSrc, listDest, ParentBean.class);

			System.out.println(JSONValue.toJSONString(listSrc));
			System.out.println(JSONValue.toJSONString(listDest));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
