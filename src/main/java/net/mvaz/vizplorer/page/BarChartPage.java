package net.mvaz.vizplorer.page;

import net.mvaz.click.graphs.D3BarChart;


@SuppressWarnings("serial")
public class BarChartPage extends BorderPage {

	public String title = "BarGraph";
	
	protected D3BarChart barchart = new D3BarChart("zbr");
	
    public BarChartPage() {
    	addControl(barchart);
    }

}