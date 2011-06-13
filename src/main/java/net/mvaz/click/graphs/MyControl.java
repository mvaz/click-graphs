package net.mvaz.click.graphs;

import org.apache.click.control.AbstractControl;

public class MyControl extends AbstractControl {
	
	protected String name = "Bond, James Bond";
	
	public MyControl(String newName) {
		name = newName;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return String.format("hello, my name is %s", name); 
	}
}
