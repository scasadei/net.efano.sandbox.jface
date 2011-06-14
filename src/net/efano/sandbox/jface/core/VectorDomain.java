package net.efano.sandbox.jface.core;

public class VectorDomain<T> extends DomainSWTObservableValue0 {

	@SuppressWarnings("unchecked")
	public void add(T elem) {
		((VectorSymbolic<T>) symbolic()).data.add(elem);
	}

	
}
