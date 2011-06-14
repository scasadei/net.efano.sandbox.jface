package com.efandei.memori.core;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;

public class DomainSWTObservableValue0 extends AbstractObservableValue implements Framed,Symbolic {

	Frame context;
	Symbolic generator;
	
	public DomainSWTObservableValue0 (Frame aFrame, Symbolic aSymbolic) {
		context = aFrame;
		generator = aSymbolic;
	}
	
	DomainSWTObservableValue0() {
		
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

	@Override
	public Object getValueType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object doGetValue() {
		// TODO Auto-generated method stub
		return null;
	}
}
