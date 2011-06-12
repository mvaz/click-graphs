package net.mvaz.vizplorer.page;

import java.util.Date;

import org.apache.click.ActionResult;
import org.apache.click.Control;
import org.apache.click.Page;
import org.apache.click.ajax.DefaultAjaxBehavior;
import org.apache.click.control.ActionLink;

/**
 * Demonstrates how an ActionResult can return a JSON response.
 */
public class JsonResponsePage extends Page {

    private static final long serialVersionUID = 1L;

    private ActionLink link = new ActionLink("link", "here");

    public JsonResponsePage() {
        link.setId("link-id");

        addControl(link);

        // Add an Ajax behavior to the link. The behavior will be invoked when the
        // link is clicked. See the basic-ajax-demo.htm template for the client-side
        // Ajax code
        link.addBehavior(new DefaultAjaxBehavior() {

            @Override
            public ActionResult onAction(Control source) {
                // Formatted date instance that will be added to the
            	String now = (new Date()).toString();
//                String now = format.currentDate("MMM, yyyy dd HH:MM:ss");
                System.out.println("ONACTION");
                String msg = "{\"msg\": \"JSON returned at: \", \"date\": \"" + now + "\"}";
                // Return an action result containing the message
                return new ActionResult(msg, ActionResult.JSON);
            }
        });
    }
}
