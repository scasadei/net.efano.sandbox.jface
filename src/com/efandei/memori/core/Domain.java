package com.efandei.memori.core;

public class Domain  implements Framed,Symbolic {

	Frame context;
	Symbolic generator;
	
	public Domain (Frame aFrame, Symbolic aSymbolic) {
		context = aFrame;
		generator = aSymbolic;
	}
	
	Domain() {
		
	}
	
	public Frame context() {
		return context;
	}
	
	public Object symbolic() {
		return generator.symbolic();
	}
	
	public Object definition() {
		return symbolic();
	}

}
