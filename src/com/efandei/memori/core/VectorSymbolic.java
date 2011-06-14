package com.efandei.memori.core;
import java.util.Vector;

public class VectorSymbolic<T> implements Symbolic {


		Vector<T> data;

		public Vector<T> getSymbolic() {
			return data; 
		}
		
		public VectorSymbolic() {
			data = new Vector<T>(0);
		}
		
		@Override
		public Vector<T>  symbolic() {
			return data;
		}

		public void add(T elem) {
			data.add(elem);
		}

		public void println() {
			System.out.println(data.toString());
		}

		public Object[] toArray() {
			return data.toArray();
		}
		
}
