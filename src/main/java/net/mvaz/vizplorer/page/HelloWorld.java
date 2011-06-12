package net.mvaz.vizplorer.page;

import java.util.Date;

import org.apache.click.Page;

@SuppressWarnings("serial")
public class HelloWorld extends Page {

    private Date time = new Date();

    public HelloWorld() {
        addModel("time", time);
    }

}