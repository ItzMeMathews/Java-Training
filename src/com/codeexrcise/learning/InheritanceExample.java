package com.codeexrcise.learning;

class Base {
	public void print() {
		System.out.println("Base");
	}
}

class Derived extends Base {
	public void print() {
		System.out.println("Derived");
	}

}

public class InheritanceExample {

	public static void Delegate(Base o) {
		o.print();
	}

	public static void main(String[] args) {
		Base a = new Base();
		Base b = new Derived();
		Derived c = new Derived();
		
		Delegate(a);
		Delegate(b);
		Delegate(c);
	}

}
