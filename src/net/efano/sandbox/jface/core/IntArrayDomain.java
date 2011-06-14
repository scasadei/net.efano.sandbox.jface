package net.efano.sandbox.jface.core;

public class IntArrayDomain extends Domain {

	IntArrayDomain(Frame aContext,int len) {
		super(aContext,new IntArraySymbolic(len));
	}
	
	public int getElement(int k) {
		return ((IntArraySymbolic)generator).getElement(k);
	}
}
