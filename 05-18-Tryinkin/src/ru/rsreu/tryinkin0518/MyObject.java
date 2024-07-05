package ru.rsreu.tryinkin0518;

public abstract class MyObject {
	private String name;

	public MyObject() {
		
	}

	public String getName() {
		return this.name;
	}

	public void setName(String argument) {
		this.name = argument;
	}

	public abstract StringBuilder printTotalInfo(int count);
}
