package com.He.W.onebone.circuit.cu.settings;

public class Setting {
	private Object[] prefix;
	/*
	 * �����Ƚ��� ������ ������� ���� ��
	 * prefix id
	 * 0 : Typeface
	 */
	public static void writeSettings(EnumSettings es, int value){
		
	}
	public static int readSettings(EnumSettings es){
		return 0;
	}
	public Object getPrefix(int id) {
		return prefix[id];
	}
	public void setPrefix(int id, Object obj) {
		this.prefix[id] = obj;
	}
	
	
}