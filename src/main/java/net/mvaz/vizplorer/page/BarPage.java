package net.mvaz.vizplorer.page;

import java.util.Arrays;
import java.util.List;

import org.apache.click.element.CssImport;
import org.apache.click.element.JsImport;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SuppressWarnings("serial")
public class BarPage extends BorderPage {

	public String title = "BarGraph";
	
	public static String getArray() {
    	Gson gson = new GsonBuilder().create();
    	List<Integer> list = Arrays.asList( new Integer[]{1, 2,3,5,7});
     	String s = gson.toJson(list);
		return s;
    }
    
    public BarPage() {
    	getHeadElements().add(new JsImport("/assets/d3.js"));
    	getHeadElements().add(new CssImport("/bar.css"));
    	System.out.println(getHeadElements());
    	
    	addModel("data", getArray());
    }

}