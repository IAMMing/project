package com.zero.traversal.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

/**
 * 
 * TravesalMap.java
 * 
 * @description 遍历map
 * @author ldm
 * @date 2016年12月27日
 * @detail
 */
public class TravesalMap {
	public void searchNode(Map<String, Object> src, Map<String, Object> dest) {
		for (Entry<String, Object> entry : src.entrySet()) {
			if (entry.getValue() instanceof Map) {
				Map<String, Object> temp = new HashMap<>();
				searchNode((Map<String, Object>) entry.getValue(), temp);
				dest.put(entry.getKey(), temp);
			} else {
				dest.put(entry.getKey(), entry.getValue());
			}
		}
	}

	public static void main(String[] args) {
		Map<String, Object> parent = new HashMap<>();
		parent.put("a", 1);
		parent.put("b", 2);
		Map<String, Object> child1 = new HashMap<>();
		child1.put("c1", 1);
		child1.put("c2", 1);
		child1.put("c2", 1);
		parent.put("child1", child1);
		Map<String, Object> child2 = new HashMap<>();
		child2.put("d1", 1);
		child2.put("d2", 1);
		parent.put("child2", child2);

		Map<String, Object> dest = new HashMap<>();
		TravesalMap travesalMap = new TravesalMap();
		travesalMap.searchNode(parent, dest);
		System.out.println(JSONValue.toJSONString(parent));
		System.out.println(JSONValue.toJSONString(dest));
	}
}
