package net.mvaz.vizplorer.page;

import java.util.Arrays;
import java.util.List;

import org.apache.click.element.CssImport;
import org.apache.click.element.JsImport;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SuppressWarnings("serial")
public class LinePage extends BorderPage {

	public String title = "LineGraph";	

//	@Override
//	public List getHeadElements() { 
//        // We use lazy loading to ensure the JS import is only added the 
//        // first time this method is called. 
//        if (headElements == null) { 
//            // Get the head elements from the super implementation 
//            headElements = super.getHeadElements(); 
//
//            
//            headElements.add(jsImport); 
//        } 
//        return headElements; 
//    }
	
	private static String getArray() {
    	Gson gson = new GsonBuilder().create();
    	List<Integer> list = Arrays.asList( new Integer[]{1, 2,3,5,6});
     	String s = gson.toJson(list);
		return s;
    }
    
    public LinePage() {
    	getHeadElements().add(new JsImport("/assets/d3.js"));
    	getHeadElements().add(new CssImport("/line.css"));
    	System.out.println(getHeadElements());
    	
    	addModel("data", getArray());
    }

}