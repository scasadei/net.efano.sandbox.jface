package com.efandei.memori.core;

import java.util.Vector;

public class StringVectorSymbolic implements Symbolic {

	Vector<String> strings;

	public Vector<String> getSymbolic() {
		return strings; 
	}
	
	public StringVectorSymbolic() {
		strings = new Vector<String>(0);
	}
	
	@Override
	public Vector<String>  symbolic() {
		return strings;
	}

	public void add(String newData) {
		strings.add(newData);
	}

	public void println() {
		System.out.println(strings.toString());
	}

	public Object[] toArray() {
		return strings.toArray();
	}
	
}
