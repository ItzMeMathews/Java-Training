package com.codeexrcise.learning;

public final class ImmutableClass {

	final private StringBuilder name;

	public static void main(String[] args) {
		ImmutableClass emp = new ImmutableClass(new StringBuilder("Mathews"));
		// emp.name = new StringBuilder("George");

	}

	public ImmutableClass(StringBuilder name) {
		super();
		this.name = name;
	}

	public StringBuilder getName() {
		return name;
	}
}
