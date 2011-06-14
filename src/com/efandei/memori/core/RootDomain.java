package com.efandei.memori.core;

public class RootDomain extends Domain {

	RootDomain(SessionFrame aSession, Symbolic aSymbolic) {
	super(aSession,aSymbolic);
	finishConstruction();
}

	RootDomain(SessionFrame aSession, String aString) {
		super(aSession, new StringSymbolic(aString));
		finishConstruction();
	}

	private void finishConstruction() {
		Frame subf = new DomainFrame(context,this);
		context.addSubframe(subf);
	}
}
