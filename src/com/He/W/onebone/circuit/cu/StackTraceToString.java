package com.He.W.onebone.circuit.cu;

import java.io.StringWriter;
import java.io.PrintWriter;

public class StackTraceToString {
	public static String convert(Throwable t){
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		return sw.toString();
	}
}
