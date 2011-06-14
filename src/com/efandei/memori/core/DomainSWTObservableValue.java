package com.efandei.memori.core;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;

public class DomainSWTObservableValue extends AbstractObservableValue implements Framed,Symbolic {

	Domain domain;
	
	public DomainSWTObservableValue (Domain aDomain){
		domain = aDomain;
	}

	public DomainSWTObservableValue (Frame aFrame, Symbolic aSymbolic) {
		domain = new Domain(aFrame,aSymbolic);
	}
	
	DomainSWTObservableValue() {
	}
	
	@Override
	public Frame context() {
		return domain.context();
	}
	
	@Override
	public Object symbolic() {
		return domain.symbolic();
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
