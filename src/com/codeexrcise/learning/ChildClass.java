package com.codeexrcise.learning;

public class ChildClass extends ParentClass {

	public ChildClass() {
		super("Name");
		System.out.println("Child Class Default Constructor");

	}

	String firstName;

	public ChildClass(String firstName) {
		super("Name");
		this.firstName = firstName;
		System.out.println("Child Class Explicit Constructor");

	}

}
