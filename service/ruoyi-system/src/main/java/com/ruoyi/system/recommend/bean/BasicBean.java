package com.ruoyi.system.recommend.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A row of data sets describes in witch the parameters are included.
 * 
 * @author wqd 2016/01/18
 */
public class BasicBean {
	private final List<String> parameters;

	private final boolean tableHead;

	public BasicBean(boolean head) {
		parameters = new ArrayList<>();
		this.tableHead = head;
	}

	public BasicBean(String... strings) {
		this(false, strings);
	}

	public BasicBean(boolean head, String... strings) {
		parameters = new ArrayList<>();
		Collections.addAll(parameters, strings);
		this.tableHead = head;
	}
	
	public int add(String param) {
		parameters.add(param);
		return this.getSize();
	}
	

	public boolean set(int index, String param) {
		if(index < this.getSize()) {
			parameters.set(index, param);
		} else {
			return false;
		}
		return true;
	}

	public boolean isHead() {
		return tableHead;
	}
	

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(" ");
		int len = 1;
		for (String string : parameters) {
			str.append("\t|").append(string);
			if(len++ % 20 == 0) {
				str.append("\n");
			}
		}
		return str.toString();
	}
	

	public int getSize() {
		return parameters.size();
	}
	

	public List<String> getArray() {
		return this.parameters;
	}
	

	public long getId() {
		return this.getLong(0);
	}
	
	public String getString(int index) {
		return parameters.get(index);
	}
	
	public long getLong(int index) {
		return Long.parseLong(parameters.get(index));
	}

	/**
	 * @param index 下标
	 * @return 是否
	 */
	public boolean getBoolean(int index) {
		return Boolean.parseBoolean(parameters.get(index));
	}
	
	public float getFloat(int index) {
		return Float.parseFloat(parameters.get(index));
	}
}
