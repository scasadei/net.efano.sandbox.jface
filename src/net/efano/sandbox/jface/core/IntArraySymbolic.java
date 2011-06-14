package net.efano.sandbox.jface.core;

public class IntArraySymbolic implements Symbolic {

	int [] array;
	IntArraySymbolic(int len) {
		array = new int[len];
	}

	public int getElement(int k) {
		return array[k];
	}
	
	public Object symbolic() {
		return array;
	}

}
