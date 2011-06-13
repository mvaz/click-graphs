package net.mvaz.vizplorer.page;

import net.mvaz.click.graphs.MyControl;

import org.apache.click.Page;

public class TestMyControlPage extends Page {

	MyControl control; 
	
	public TestMyControlPage() {
		control = new MyControl("control");
		addControl(control);
		System.out.println("[[constructor]]");
	}
}
