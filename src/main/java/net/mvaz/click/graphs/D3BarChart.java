package net.mvaz.click.graphs;

import java.util.Arrays;
import java.util.List;

import org.apache.click.control.AbstractControl;
import org.apache.click.element.CssImport;
import org.apache.click.element.Element;
import org.apache.click.element.JsImport;
import org.apache.click.util.HtmlStringBuffer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class D3BarChart extends AbstractControl {
	
	protected Integer width = 400;
	protected Integer height = 200;
	protected Integer margin = 20;
	
	@Override
	public List<Element> getHeadElements() {
		if (headElements == null) {
			headElements = super.getHeadElements();
			
			headElements.add( new JsImport("/assets/d3.js"));
			headElements.add( new CssImport("/bar.css"));
		}
		return headElements;
	}
	
	public D3BarChart(String name) {
		super(name);
	}
	
	protected void renderScript(HtmlStringBuffer buffer, String divName) {
		
		buffer.append(String.format("var data = %s;", getData()));
		buffer.append(String.format("var w = %d;", width));
		buffer.append(String.format("var h = %d;", height));
		buffer.append(String.format("var margin = %d;", margin));
		buffer.append("var x = d3.scale.linear().domain([0, data.length]).range([0 + margin, w - margin]);");
		buffer.append("var y = d3.scale.linear().domain([0, d3.max(data)]).range([0 + margin, h - margin])");
		buffer.append("\n");
		buffer.append("var chart = d3.select(\"#" + divName + "\")");
		buffer.append(".append(\"svg:svg\")");
		buffer.append(".attr(\"class\", \"bar\")");
		buffer.append(".attr(\"height\", h)");
		buffer.append(".attr(\"width\", w);");
		buffer.append("\n");
		buffer.append("chart.selectAll(\"rect\")" +
				      "      .data(data)" +
				      "      .enter().append(\"svg:rect\")" +
				      "	     .attr(\"x\", function(d, i) { return x(i);})" +
				      "	     .attr(\"y\", function(d) { return h - margin - y(d);})" +
				      " 	 .attr(\"width\", x(1) - x(0))" +
				      "	     .attr(\"height\", y);" );
		
		System.out.println(buffer.toString());
	}
	
	@Override
	public void render(HtmlStringBuffer buffer) {
		String divName = getName();
		
		buffer.elementStart("div");
		buffer.appendAttribute("id", divName);
		buffer.closeTag();
		
		buffer.elementStart("script");
		buffer.appendAttribute("type", "text/javascript");
		buffer.closeTag();
	
		renderScript(buffer, divName);
		
		buffer.elementEnd("script");
		buffer.elementEnd("div");
	}

	@Override
	public String toString() { 
        int estimatedSizeOfControl = 400; 
        HtmlStringBuffer buffer = new HtmlStringBuffer(estimatedSizeOfControl); 
        render(buffer); 
        return buffer.toString(); 
    } 
	
	
	private String getData() {
		Gson gson = new GsonBuilder().create();
		List<Integer> list = Arrays.asList(new Integer[] { 1, 2, 3, 5, 7 });
		String s = gson.toJson(list);
		return s;
	}	
	
}
